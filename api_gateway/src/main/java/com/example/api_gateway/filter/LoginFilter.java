package com.example.api_gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 登录过滤器
 * @Author: Sijie Zhi
 * @Date: 2018/12/28 14:05
 */
//@Component
public class LoginFilter  extends ZuulFilter {
    /**
     * 过滤器类型，前置过滤器
     * @return
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }
    /**
     * 过滤器顺序，越小越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 4;
    }
    /**
     * 过滤器是否生效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext requestContext=RequestContext.getCurrentContext();
        HttpServletRequest request=requestContext.getRequest();

        if("/zuulgetserver/product/api/v1/product/list".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }else{
            System.out.println("return false~~~~~~ 没有登录");
        }
        return false;
    }

    /**
     * 业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        //JWT
        RequestContext requestContext =  RequestContext.getCurrentContext();
        HttpServletRequest  request = requestContext.getRequest();
        //token对象
        String token = request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            token = request.getParameter("token");
        }
        System.out.println(">>>>>>>>>>>>进了 loginFilter");
        if(StringUtils.isBlank(token)){
            requestContext.setSendZuulResponse(false);//没获取到token 证明木有登录，不放行
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
