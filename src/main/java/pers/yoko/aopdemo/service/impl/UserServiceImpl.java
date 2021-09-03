package pers.yoko.aopdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.repository.UserRepository;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author yoko
 * @date 2021/9/1 10:53
 * @since 1.0
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void insertUser(User user) {
        System.out.println("方法insertUser执行中...");
    }

    @Override
    public User queryUser(Integer id) {
        System.out.println("方法queryUser执行中...");
        return new User(1, "query user");
    }
}
