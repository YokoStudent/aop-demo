package pers.yoko.aopdemo.advice;

import org.junit.Assert;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author yoko
 * @date 2021/9/3 14:42
 * @since 1.0
 */
public class SpringAdvice {
    /**
     * 代理模式需要一个接口，一个具体实现类，然后就是一个代理类，包装实现类，添加自定义逻辑
     * userServiceProxy就是一个代理的类
     * advice问题：1.拦截器的粒度只控制到了类级别；2.如果要拦截其他的类又要定义一个代理。
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-advice.xml");
        UserService userService = (UserService) context.getBean("userServiceProxy");
        User user = userService.queryUser(1);
        Assert.assertNotNull(user);
    }
}
