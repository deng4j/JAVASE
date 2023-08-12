package dzh.com.DesignPattern.DesignPattern.structuralPatterns.proxy.dynamicProxy.JDK;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理：基于Java反射机制实现，必须要实现了接口的业务类才生成代理对象。
 *
 * RealStar必须实现一个接口，如Star接口。即使这个接口没有任何的实现类，也可以根据这个接口信息，创建一个代理类。
 */
public class StarProxy implements InvocationHandler {
    Object target;

    /**
     * 获取代理对象
     */
    public Object getInstance(Object target) throws Exception {
        this.target = target;
        Class<?> clazz = target.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    /**
     * 在这里控制动态代理，代理调任何方法都会来invoke这里来报到
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object obj = null;
        System.out.println("代理方法："+method.getName());

        if (method.getName().equals("sing")){
            System.out.println("助理订机票");
            obj = method.invoke(this.target, args);
            System.out.println("助理打扫卫生");
            return obj;
        }

        obj = method.invoke(this.target, args);
        return obj;
    }
}
