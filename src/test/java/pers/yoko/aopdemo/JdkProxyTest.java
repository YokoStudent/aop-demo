package pers.yoko.aopdemo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.proxy.jdk.handler.JdkHandler;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author yoko
 * @date 2021/9/1 11:18
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class JdkProxyTest {

    @Autowired
    private UserService userService;

    @Test
    public void main() {
        JdkHandler jdkHandler = new JdkHandler(userService);
        userService = JdkHandler.proxy(userService.getClass().getClassLoader(), userService.getClass().getInterfaces(), jdkHandler);
        userService.insert(new User(1, "yoko"));
    }
}
