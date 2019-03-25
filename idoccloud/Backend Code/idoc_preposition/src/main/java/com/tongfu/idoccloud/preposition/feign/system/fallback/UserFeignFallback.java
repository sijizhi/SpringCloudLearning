package com.tongfu.idoccloud.preposition.feign.system.fallback;

import com.tongfu.idoccloud.preposition.entity.User;
import com.tongfu.idoccloud.preposition.feign.system.UserFeign;
import com.tongfu.idoccloud.preposition.utils.InformError;
import com.tongfu.idoccloud.preposition.utils.MapVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 16:37
 */
@Component
public class UserFeignFallback implements UserFeign {

    /**
     * 调用失败发送通知
     */
    @Autowired
    private InformError informError;

    @Override
    public Object   login( String  userCode,  String  password,  String db_name,String ip,String deviceNumber) {
        informError.sendInform("trongfu:errorInform:login","/api/user/v1/login登录调用服务失败！");
        return new User(0);
    }

    @Override
    public Object checkPassword( String  userCode,String password,  String idoc_token) {
        informError.sendInform("trongfu:errorInform:checkPassword","/api/user/v1/checkPassword密码检测调用服务失败！");
        return MapVo.returnMap("result",false );
    }

    @Override
    public Object changeInitPass(String userCode, String password, String idoc_token) {
        informError.sendInform("trongfu:errorInform:changeInitPass","/api/user/v1/changeInitPass初始密码修改调用服务失败！");
        return MapVo.returnMap("result",false );
    }
}
