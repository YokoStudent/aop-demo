package pers.yoko.aopdemo.proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.proxy.cglib.interceptor.CglibInterceptor;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author yoko
 * @date 2021/9/1 11:18
 * @since 1.0
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CglibProxyTest {

    @Autowired
    private UserService userService;

    @Test
    public void main() {
        CglibInterceptor cglibInterceptor = new CglibInterceptor(userService);
        userService = CglibInterceptor.proxy(userService.getClass(), cglibInterceptor);
        userService.insertUser(new User(1, "yoko"));
    }
}
