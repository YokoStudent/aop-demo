package pers.yoko.aopdemo.advisor;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author zhangyong
 * @date 2021/9/3 16:14
 * @since 1.0
 */
public class SpringAutoProxyAdvisor {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-defaultAdvisorAutoProxy.xml");
        UserService userService = context.getBean(UserService.class);
        userService.queryUser(1);
        userService.insertUser(new User(1,"yoko"));
    }
}
