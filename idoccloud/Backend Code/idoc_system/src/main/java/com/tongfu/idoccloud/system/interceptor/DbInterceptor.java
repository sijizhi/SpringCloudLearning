package com.tongfu.idoccloud.system.interceptor;

import com.tongfu.idoccloud.system.entity.User;
import com.tongfu.idoccloud.system.utils.DbUtil;

import com.tongfu.idoccloud.system.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;

/**
 * @Author: SiJie Zhi
 * @Date: 2018/9/22 21:16
 */
public class DbInterceptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 进入ctroller之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {

        InetAddress address = InetAddress.getLocalHost();
        System.out.println("===============before ctroller=============="+address);
        String db_name=request.getParameter("db_name");
        String idoc_token=request.getParameter("idoc_token");

        if(!StringUtils.isEmpty(idoc_token)){
            User user = jwtUtil.decode(idoc_token, User.class);
            db_name=user.getDb_name();
        }
        if(StringUtils.isEmpty(db_name)){
            System.out.println(">>>>>>>>>>>db_name 为空被拦截");
            return  false;
        }
        DbUtil.setDbName(db_name);
        return HandlerInterceptor.super.preHandle(request, response,handler );
    }

    /**
     * 调用controller之后，页面渲染前执行
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request,response ,handler ,modelAndView );
    }

    /**
     * 全部结束后，常用于资源清理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request,response ,handler ,ex );
    }
}
