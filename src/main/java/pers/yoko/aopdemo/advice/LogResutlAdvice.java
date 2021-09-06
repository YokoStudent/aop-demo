package pers.yoko.aopdemo.advice;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yoko
 * @date 2021/9/3 14:13
 * @since 1.0
 */
public class LogResutlAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnVal, Method method, Object[] objects, Object target) {
        System.out.println("执行方法：" + method.getName() + ",参数列表:" + Arrays.toString(objects) + ",返回结果:" + returnVal);
    }
}
