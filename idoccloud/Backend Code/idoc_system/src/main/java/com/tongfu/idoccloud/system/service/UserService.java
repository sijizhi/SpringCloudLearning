package com.tongfu.idoccloud.system.service;

import com.tongfu.idoccloud.system.entity.User;

/**
 * @Author: Sijie Zhi
 * @Date: 2019/3/12 15:54
 */
public interface UserService {

    User login(User user);

    boolean checkPassword(User user);

    boolean changeInitPass(User user);

}
