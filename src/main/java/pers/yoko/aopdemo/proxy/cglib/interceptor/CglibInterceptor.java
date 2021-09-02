package pers.yoko.aopdemo.proxy.cglib.interceptor;

import com.alibaba.fastjson.JSON;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;

/**
 * cglib动态代理模拟
 * 优点：能代理接口和类
 * 缺点：不能代理final类
 * @author yoko
 * @date 2021/9/1 14:21
 * @since 1.0
 */
public class CglibInterceptor implements MethodInterceptor {

    private Object target;

    public CglibInterceptor(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object invoke;
        try {
            System.out.println("方法" + getClassNameAndMethod(target, method) + ",参数：" + JSON.toJSONString(objects) + ",调用开始时间：" + getCurrentTime());
            invoke = methodProxy.invoke(target, objects);
            System.out.println("方法" + getClassNameAndMethod(target, method) + "调用结束时间：" + getCurrentTime());
        } catch (Exception e) {
            System.out.println("方法" + getClassNameAndMethod(target, method) + " 异常：" + e.getCause());
            throw e;
        }
        return invoke;
    }

    public static <T> T proxy(Class<?> clz, MethodInterceptor interceptor) {
        return (T) Enhancer.create(clz, interceptor);
    }

    private String getClassNameAndMethod(Object object, Method method) {
        return target.getClass() + "#" + method.getName();
    }

    private String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }
}
