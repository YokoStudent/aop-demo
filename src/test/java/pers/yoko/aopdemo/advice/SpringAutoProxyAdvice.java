package pers.yoko.aopdemo.advice;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pers.yoko.aopdemo.entity.Dept;
import pers.yoko.aopdemo.service.DeptService;
import pers.yoko.aopdemo.service.UserService;

/**
 * @author yoko
 * @date 2021/9/3 15:41
 * @since 1.0
 */
public class SpringAutoProxyAdvice {
    /**
     * 使用BeanNameAutoProxyCreator，不用关心代理，直接使用就行
     * BeanNameAutoProxyCreator是自己匹配方法，然后交由内部配置advice来拦截处理
     */
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-beanNameAutoProxy.xml");
        UserService userService = context.getBean(UserService.class);
        userService.queryUser(1);
        DeptService deptService = context.getBean(DeptService.class);
        deptService.createDept(new Dept(1,"研发部门"));
    }
}
