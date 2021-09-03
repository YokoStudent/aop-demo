package pers.yoko.aopdemo.service;

import pers.yoko.aopdemo.entity.User;

/**
 * @author yoko
 * @date 2021/9/1 10:51
 * @since 1.0
 */
public interface UserService {
    void insertUser(User user);

    User queryUser(Integer id);
}
