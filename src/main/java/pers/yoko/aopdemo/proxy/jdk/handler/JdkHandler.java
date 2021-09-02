package pers.yoko.aopdemo.proxy.jdk.handler;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

/**
 * jdk动态代理模拟
 * 只能代理接口
 * @author yoko
 * @date 2021/9/1 10:57
 * @since 1.0
 */
public class JdkHandler implements InvocationHandler {

    private Object target;

    public JdkHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object invoke;
        try {
            System.out.println("方法" + getClassNameAndMethod(target, method) + ",参数：" + JSON.toJSONString(args) + ",调用开始时间：" + getCurrentTime());
            invoke = method.invoke(target, args);
            System.out.println("方法" + getClassNameAndMethod(target, method) + "调用结束时间：" + getCurrentTime());
        } catch (Exception e) {
            System.out.println("方法" + getClassNameAndMethod(target, method) + " 异常：" + e.getCause());
            throw e;
        }
        return invoke;
    }

    @SuppressWarnings("uncheckd")
    public static <T> T proxy(ClassLoader classLoader, Class<?>[] clz, InvocationHandler handler) {
        return (T) Proxy.newProxyInstance(classLoader, clz, handler);
    }

    private String getClassNameAndMethod(Object object, Method method) {
        return target.getClass() + "#" + method.getName();
    }

    private String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(System.currentTimeMillis());
    }
}
