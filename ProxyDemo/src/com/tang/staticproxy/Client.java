package com.tang.staticproxy;

/**
 * @ClassName: Client
 * @author: TZL
 * @date: 2020/11/24  14:00
 * @Description: 客户
 */
public class Client {

    public static void main(String[] args) {
        Task task = ProxyTaskFactory.getInstance();
        task.doWork("GO!!! GO!!! GO!!! ");
    }

}
