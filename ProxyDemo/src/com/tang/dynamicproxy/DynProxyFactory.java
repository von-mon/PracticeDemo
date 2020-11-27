package com.tang.dynamicproxy;

import com.tang.staticproxy.RealTask;
import com.tang.staticproxy.Task;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName: DynProxyFactory
 * @author: TZL
 * @date: 2020/11/24  14:37
 * @Description: 动态代理对象工厂,客户类调用此工厂方法获得代理对象。对客户类来说，其并不知道返回的是代理类对象还是委托类对象
 */
public class DynProxyFactory {

    public static Task getInstance() {
        Task delegate = new RealTask();
        InvocationHandler handler = new TaskInvocationHandler(delegate);
        Task proxy = null;
        proxy = (Task) Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                handler);
        return proxy;
    }

}
