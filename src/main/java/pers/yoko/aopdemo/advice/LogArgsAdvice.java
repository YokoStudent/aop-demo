package pers.yoko.aopdemo.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author yoko
 * @date 2021/9/3 14:10
 * @since 1.0
 */
public class LogArgsAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) {
        System.out.println("执行方法:" + method.getName() + ",参数列表:" + Arrays.toString(objects));
    }
}
