package pers.yoko.aopdemo.aspect;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author zhangyong
 * @date 2021/9/6 17:43
 * @since 1.0
 */
public class SpringAspect {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-aspect.xml");
        UserService userService = context.getBean(UserService.class);
        User user = userService.queryUser(1);
        Assert.assertNotNull(user);
    }
}
