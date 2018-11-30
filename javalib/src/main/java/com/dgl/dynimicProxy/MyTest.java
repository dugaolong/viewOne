package com.dgl.dynimicProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 */

public class MyTest {
    public static void main(String[] args) {
        //目标对象
        final IMarry person = new Person();
        //代理对象
        IMarry marryProxy = (IMarry) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),//目标类的类加载器
                person.getClass().getInterfaces(),//目标类所实现的所有的接口
                new InvocationHandler() {         //内部匿名类
                    //增强就在这里完成
                    //proxy:代理对象
                    //method:目标方法
                    //目标方法的参数列表
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args)
                            throws Throwable {
                        Object res = method.invoke(person, args);
                        return res;
                    }
                });
        marryProxy.marry();
    }
}
