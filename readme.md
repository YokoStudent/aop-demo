### 使用AOP的好处
+ 降低耦合度
+ 使系统更容易扩展
+ 提高代码服用度

### AOP的基本概念
+ 连接点（JoinPoint）：需要在程序中插入横切关注点的点
+ 切入点（PointCut）：一组相关连接点的集合
+ 通知（Advice）：在连接点执行的行为，前置（before advice），后置（after advice），环绕（around advice）
+ 切面（Aspect）：通知和切入点的集合
+ 织入（Weaving）：将切面应用到目标对象从而创建出AOP代理对象的过程
+ 代理（Proxy）：通过代理方式来对目标对象应用切面。AOP代理可以用JDK或CGLIB代理实现
+ 目标对象（Target）：即被代理的对象

### 动态代理
动态代理本质：对目标对象增强。

代理限制：只能在父类调用之前或之前增强，不能在中间修改，要想在方法中增强，需要ASM（Java字节码生产器）。

1. JDK动态代理： 只能代理接口，实现InvocationHandler接口
```java
/**
 * proxy: 代理类实例
 * method: 原对象被调用的方法
 * args: 方法的参数
 */
public Object invoke(Object proxy, Method method, Object[] args)throws Throwable;

/**
 * classLoader: 产生代理对象的类加载器
 * clz: 目标对象的接口数组
 * handler: 实现InvocationHandler接口的实例
 */
public static <T> T proxy(ClassLoader classLoader, Class<?>[] clz, InvocationHandler handler) {
    return (T) Proxy.newProxyInstance(classLoader, clz, handler);
}
```

2. CGLIB动态代理：可以代理类和接口，不能代理final类，实现MethodInterceptor接口
```java
/**
 * object: 生成的代理类实例
 * method: 被代理对象的方法引用
 * objects: 方法参数值数组
 * invocation: 代理类对方法的代理引用 
 */
Object intercept(Object object, Method method, Object[] objects, MethodProxy invocation) throws Throwable;

/**
 * clz: 目标对象的接口数组
 * interceptor: 实现MethodInterceptor接口的实例
 */
public static <T> T proxy(Class<?> clz, MethodInterceptor interceptor) {
    return (T) Enhancer.create(clz, interceptor);
    }
```

### JDK动态代理源码
链接：https://www.jianshu.com/p/269afd0a52e6
