package com.example.api_gateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * 订单限流
 */
//@Component
public class OrderRateLimiterFilter extends ZuulFilter {


    //每秒产生1000个令牌
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(1000);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return -4;
    }



    @Override
    public boolean shouldFilter() {


        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        //只对订单接口限流
        if ("/apigateway/order/api/v1/order/save".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }else {
            System.out.println("return false ----限流没过");
        }
        return false;
    }

    /**
     * 处理
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        if(!RATE_LIMITER.tryAcquire()){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.TOO_MANY_REQUESTS.value());
        }
        return null;
    }



}
