package pers.yoko.aopdemo.advisor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yoko.aopdemo.entity.Dept;
import pers.yoko.aopdemo.entity.User;
import pers.yoko.aopdemo.service.DeptService;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author yoko
 * @date 2021/9/3 15:09
 * @since 1.0
 */
public class SpringAdvisor {
    /**
     * advisor拦截的粒度更细，只有当mappedNames指定的方法才会被拦截
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-advisor.xml");
        UserService userService = (UserService) context.getBean("userServiceProxy");
        userService.insertUser(new User(1,"yoko"));
        // queryUser 不会被拦截
        userService.queryUser(1);
    }
}
