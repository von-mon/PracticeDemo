package com.tang.dynamicproxy;

import com.tang.staticproxy.Task;

/**
 * @ClassName: Client
 * @author: TZL
 * @date: 2020/11/24  14:57
 * @Description:
 */
public class Client {

    public static void main(String[] args) {

        Task proxy = DynProxyFactory.getInstance();
        proxy.doWork("DBQueryTask");
    }
}
