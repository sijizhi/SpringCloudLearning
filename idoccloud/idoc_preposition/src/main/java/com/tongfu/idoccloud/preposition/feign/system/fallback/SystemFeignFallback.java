package com.tongfu.idoccloud.preposition.feign.system.fallback;

import com.sun.xml.internal.ws.client.RequestContext;
import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.feign.system.SystemFeign;
import com.tongfu.idoccloud.preposition.utils.InformError;
import com.tongfu.idoccloud.preposition.utils.MapVo;
import com.tongfu.idoccloud.preposition.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Map;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 16:37
 */
@Component
public class SystemFeignFallback implements SystemFeign {

    /**
     * 调用失败发送通知
     */
    @Autowired
    private InformError informError;

    @Override
    public User login(User user,String db_name) {
        informError.sendInform("trongfu:errorInform:login","/api/user/v1/login登录调用服务失败！");
        return new User();
    }

    @Override
    public Object checkPassword(User user, String db_name) {
        informError.sendInform("trongfu:errorInform:checkPassword","/api/user/v1/checkPassword密码检测调用服务失败！");
        return MapVo.returnMap("check",false );
    }
}
