package com.tang.staticproxy;

/**
 * @ClassName: ProxyTask
 * @author: TZL
 * @date: 2020/11/24  13:55
 * @Description: 代理类，实现代理接口
 */
public class ProxyTask implements Task {
    //持有委托类的引用
    public Task delegate;

    public ProxyTask(Task delegate){
        this.delegate = delegate;
    }

    @Override
    public void doWork(String taskName) {
        long startTime = System.currentTimeMillis();
        delegate.doWork(taskName); //将任务分配给委托类处理
        long endTime = System.currentTimeMillis();
        System.out.println("执行所需时间： "+ (endTime - startTime) / 1000.0 + "秒");
    }
}
