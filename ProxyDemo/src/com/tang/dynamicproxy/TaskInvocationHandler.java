package com.tang.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName: TaskInvocationHandler
 * @author: TZL
 * @date: 2020/11/24  14:33
 * @Description: 动态代理类对应的调用处理程序类
 */
public class TaskInvocationHandler implements InvocationHandler {

    private Object delegate; // 持有委托类的对象引用

    public TaskInvocationHandler(Object delegate){
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        //利用反射机制将请求分派给委托类处理。Method的invoke返回Object对象作为方法执行结果。
        //因为示例程序没有返回值，所以这里忽略了返回值处理
        method.invoke(delegate, args);
        long endTime = System.currentTimeMillis();
        System.out.println("执行任务耗时"+(endTime - startTime) / 1000.0+"秒");
        return null;
    }
}
