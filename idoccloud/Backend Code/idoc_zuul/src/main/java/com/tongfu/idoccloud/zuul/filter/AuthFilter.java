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
public class AuthFilter extends ZuulFilter {

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
        System.out.println("走网关了>>>过滤器是否生效");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //登录接口放行
       if ((url+"/sys/v1/usr/login").equalsIgnoreCase(request.getRequestURI())) {
           String db_name=request.getParameter("db_name");
           String ip=request.getParameter("ip");
           String deviceNumber=request.getParameter("deviceNumber");
           if(StringUtils.isEmpty(db_name)||
                   StringUtils.isEmpty(ip)||
                   StringUtils.isEmpty(deviceNumber)){
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
        System.out.println("走网关了>>>业务逻辑");
        //JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        //登录接口
        if ((url+"/sys/v1/usr/login").equalsIgnoreCase(request.getRequestURI())) {
            //token对象
            String db_name = request.getParameter("db_name");
            String ip = request.getParameter("ip");
            String deviceNumber=request.getParameter("deviceNumber");
            logger.info("db_name>>"+db_name);
            logger.info("ip>>"+ip);
            logger.info("ip>>"+deviceNumber);
            System.out.println("db_name>>"+db_name+">>>>>ip>>"+ip);
            if(StringUtils.isEmpty(db_name)||StringUtils.isEmpty(ip)){
                logger.error("doLogin ->db_name ip deviceNumber can't null,please check the front-end code");
                //没有客户端数据库，禁止访问
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
            }
        }else{
            //token对象
            String idoc_token = request.getHeader("idoc_token");

            //获取操作
            String operation = request.getParameter("operation");


            System.out.println("\nidoc_token="+idoc_token);
            Map<String, List<String>> requestQueryParams2 = requestContext.getRequestQueryParams();
            System.out.println(requestQueryParams2);

            //一层鉴权-请求是否带上token
            if(StringUtils.isEmpty(idoc_token)||StringUtils.isEmpty(operation)){
                //没有客户端数据库，禁止访问
                requestContext.setSendZuulResponse(false);
                requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
                requestContext.setResponseBody(JSON.toJSONString(ResponseUtil.error(ResponseEnums.PARAM_ERROR)));
            }else{
                User user = jwtUtil.decode(idoc_token, User.class);
                //二层鉴权-token是否正确
                if(user != null
//                        &redisClient.getExpire(user.getDb_name()+":login:token:"+user.getUserCode())>15
                    &&redisClient.get(user.getDb_name()+":login:token:"+user.getUserCode()).equals(idoc_token)){
                        //鉴权通过，重新设置有效时间30分钟（正式时使用）
//                        redisClient.expire(user.getDb_name()+":login:token:"+user.getUserCode(),60*30);

                    Map<String, List<String>> requestQueryParams = requestContext.getRequestQueryParams();
                    if(requestQueryParams==null){
                        requestQueryParams= new HashMap<>();
                    }
                    //附加参数
                    ArrayList<String> paramsList = new ArrayList<>();
                    paramsList = new ArrayList<>();
                    paramsList.add(idoc_token);
                    requestQueryParams.put("idoc_token", paramsList);
                    paramsList = new ArrayList<>();
                    paramsList.add(user.getUserId().toString());
                    requestQueryParams.put("userId", paramsList);

                    System.out.println(requestQueryParams);
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
