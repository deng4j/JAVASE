package JavaSE.com.GOF.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 使用jdk自带的代理。
 *
 * AOP面向切面编程：通过预编译方式和运行期动态代理实现在不修改
 * 源代码的情况下给程序动态统一添加的一种技术。他是一种新的方法论，
 * 它是对传统OOP编程的一种补充。
 */
public class StarHandler implements InvocationHandler {
    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //在这里控制动态代理，代理调任何方法都会来invoke这里来报到
        System.out.println("面谈");
        System.out.println("签合同");
        System.out.println("订机票");
        if (method.getName().equalsIgnoreCase("sing")){
            method.invoke(realStar,args);
        }
        System.out.println("收尾款");
        return null;
    }
}
