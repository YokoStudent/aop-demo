package pers.yoko.aopdemo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @author yoko
 * @date 2021/9/1 10:56
 * @since 1.0
 */
@Aspect
public class LogAspects {

    /**
     * execution:匹配方法签名
     * within:指定所在类或所在包下面的方法
     * @annotation:方法上具有特点的注解
     * bean():匹配bean的名字
     *
     * .代表一个包名,
     * ..代表包及子包
     * ..方法参数任意匹配
     */
    @Pointcut("execution(* pers.yoko.aopdemo.service..*(..))")
    private void anyService() {}

    @Before("anyService()")
    public void beforeService(JoinPoint joinPoint) {
        System.out.println("方法执行之前,参数:" + joinPoint.getArgs());
    }

    @AfterReturning(value = "anyService()", returning = "retVal")
    public void afterReturnService(Object retVal) {
        System.out.println("方法执行返回:" + retVal);
    }

    @AfterThrowing(value = "anyService()", throwing = "ex")
    public void afterThrowingService(Exception ex) {
        System.out.println("方法执行异常:" + ex.getMessage());
    }

    @After("anyService()")
    public void afterService() {
        System.out.println("方法执行完成");
    }

    @Around("anyService()")
    public Object aroundService(ProceedingJoinPoint pjp) {
        System.out.println("方法执行之前,参数(around):" + pjp.getArgs());
        Object retVal = null;
        try {
            retVal = pjp.proceed();
        } catch (Throwable throwable) {
            System.out.println("方法执行异常(around):" + throwable.getMessage());
            throwable.printStackTrace();
        } finally {
            System.out.println("方法执行完成(around)");
        }
        System.out.println("方法执行返回(around):" + retVal);
        return retVal;
    }
}
