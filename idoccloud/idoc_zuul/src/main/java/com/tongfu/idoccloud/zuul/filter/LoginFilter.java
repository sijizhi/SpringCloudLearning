package com.tongfu.idoccloud.zuul.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.tongfu.idoccloud.zuul.entity.User;
import com.tongfu.idoccloud.zuul.enums.ResponseEnums;
import com.tongfu.idoccloud.zuul.utils.JwtUtil;
import com.tongfu.idoccloud.zuul.utils.RedisClient;
import com.tongfu.idoccloud.zuul.utils.ResponseUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 登录过滤器
 *
 * @Author: Sijie Zhi
 * @Date: 2018/12/28 14:05
 */

@Component
public class LoginFilter extends ZuulFilter {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisClient redisClient;
    private String  url="/tongfu-pre/uniteapi";
    /**
     * 过滤器类型，前置过滤器
     *
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器顺序，越小越先执行
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 4;
    }

    /**
     * 过滤器是否生效
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //登录接口放行
       if ((url+"/sys/v1/usr/login").equalsIgnoreCase(request.getRequestURI())) {
           String db_name=request.getParameter("db_name");
           if(StringUtils.isEmpty(db_name)){
               return true;
           }
            return false;
        }
        return true;
    }

    /**
     * 业务逻辑
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        //登录接口
        if ((url+"/sys/v1/usr/login").equalsIgnoreCase(request.getRequestURI())) {
            //token对象
            String db_name = request.getHeader("db_name");
            if(StringUtils.isEmpty(db_name)){
                logger.error("doLogin ->db_name can't null,please check the front-end code");
                //没有客户端数据库，禁止访问
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }else{
            //token对象
            String idoc_token = request.getHeader("idoc_token");
            //获取操作
            String operation = request.getParameter("operation");
            //一层鉴权-请求是否带上token
            if(StringUtils.isEmpty(idoc_token)||StringUtils.isEmpty(operation)){
                System.out.println("idoc_token and operation不能为空");
                //没有客户端数据库，禁止访问
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                requestContext.setResponseBody(JSON.toJSONString(ResponseUtil.error(ResponseEnums.PARAM_ERROR)));
            }else{
                User user = jwtUtil.decode(idoc_token, User.class);
                //二层鉴权-token是否正确
                if(user != null
                        &redisClient.getExpire(user.getDb_name()+":login:token:"+user.getUserCode())>15
                        &&redisClient.get(user.getDb_name()+":login:token:"+user.getUserCode()).equals(idoc_token)){
                        //鉴权通过，重新设置有效时间30分钟
                        redisClient.expire(user.getDb_name()+":login:token:"+user.getUserCode(),60*30);
                        Map<String, List<String>> requestQueryParams = requestContext.getRequestQueryParams();
                        System.out.println(requestQueryParams.toString());
                        if(requestQueryParams==null){
                            requestQueryParams= new HashMap<>();
                        }
                        //附加参数
                        ArrayList<String> paramsList = new ArrayList<>();
                        paramsList.add(user.getUserCode());
                        requestQueryParams.put("userCode", paramsList);
                        paramsList = new ArrayList<>();
                        paramsList.add(user.getDb_name());
                        requestQueryParams.put("db_name", paramsList);
                        paramsList = new ArrayList<>();
                        paramsList.add(user.getUserId().toString());
                        requestQueryParams.put("userId", paramsList);
                        paramsList = new ArrayList<>();
                        paramsList.add(user.getChineseName());
                        requestQueryParams.put("chineseName", paramsList);
                        System.out.println(requestQueryParams.toString());
                }else {
                    requestContext.setSendZuulResponse(false);
                    requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                    requestContext.setResponseBody(JSON.toJSONString(ResponseUtil.error(ResponseEnums.LOGIN_ERROR)));
                }
            }

        }



        return null;
    }
}
