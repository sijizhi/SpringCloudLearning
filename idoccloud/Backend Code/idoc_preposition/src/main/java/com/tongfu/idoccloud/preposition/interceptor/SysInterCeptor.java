package com.tongfu.idoccloud.preposition.interceptor;

import com.tongfu.idoccloud.preposition.entity.LoggerEntity;
import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.service.LoggerService;
import com.tongfu.idoccloud.preposition.task.LoggerAsync;
import com.tongfu.idoccloud.preposition.utils.DbUtil;
import com.tongfu.idoccloud.preposition.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.util.concurrent.Future;

/**
 * 系统管理拦截
 * @Author: Sijie Zhi
 * @Date: 2019/3/19 10:21
 */
public class SysInterCeptor implements HandlerInterceptor {
    private Logger logger= LoggerFactory.getLogger(this.getClass());
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private LoggerService loggerService;


    /**
     * 进入控制层之前执行
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
        String uri=request.getRequestURI();
        String db_name=request.getParameter("db_name");
        String idoc_token=request.getParameter("idoc_token");
        String operation=request.getParameter("operation");

        //日志参数
        LoggerEntity loggerEntity=new LoggerEntity();
        loggerEntity.setRequestApi(uri);
        loggerEntity.setRequestService("system-service");

        if(!StringUtils.isEmpty(operation)){
            loggerEntity.setOperation(operation);
        }
        if(!StringUtils.isEmpty(idoc_token)){
            User user = jwtUtil.decode(idoc_token, User.class);
            loggerEntity.setUserId(user.getUserId());
            loggerEntity.setDepartId(user.getDepartId());
            loggerEntity.setUserName(user.getChineseName());
            loggerEntity.setUserIp(user.getIp());
            loggerEntity.setDeviceNumber(user.getDeviceNumber());
            db_name=user.getDb_name();
        }
        if(StringUtils.isEmpty(db_name)){
            return  false;
        }
        DbUtil.setDbName(db_name);
        //执行添加日志(登录日志是成功后添加）
        if(!uri.equals("/uniteapi/sys/v1/usr/login")){
            loggerService.addOperation(loggerEntity);
        }

        return HandlerInterceptor.super.preHandle(request, response,handler );
    }


    /**
     *  调用controller之后，页面渲染前执行
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
