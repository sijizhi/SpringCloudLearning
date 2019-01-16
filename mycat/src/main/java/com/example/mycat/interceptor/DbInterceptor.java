package com.example.mycat.interceptor;

import com.example.mycat.utils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.proxy.Factory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 21:16
 */
public class DbInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    //进入ctroller之前执行
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        String dbname=request.getHeader("companyName");
        if(dbname==null){
            dbname=request.getParameter("companyName");
        }
        if(dbname==null){
            logger.error("接口前拦截器不通过！");
            return false;
        }else{
            DbUtils.setDbName(dbname);
        }
        System.out.println(dbname);
        System.out.println("===============preHandle1==============");
        return HandlerInterceptor.super.preHandle(request, response,handler );//放行
    }
    // 调用controller之后，页面渲染前执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("===========postHandle1============"+DbUtils.getDbName());
        HandlerInterceptor.super.postHandle(request,response ,handler ,modelAndView );
    }
    //全部结束后，常用于资源清理
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("===========afterCompletion1============"+DbUtils.getDbName());
        HandlerInterceptor.super.afterCompletion(request,response ,handler ,ex );
    }
}
