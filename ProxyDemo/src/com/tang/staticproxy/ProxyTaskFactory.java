package com.tang.staticproxy;

/**
 * @ClassName: ProxyTaskFactory
 * @author: TZL
 * @date: 2020/11/24  14:00
 * @Description: 代理工厂
 */
public class ProxyTaskFactory {

    /**
     * 返回一个代理对象
     * @return Task 代理对象
     */
    public static Task getInstance(){
        return new ProxyTask(new RealTask());
    }
}
