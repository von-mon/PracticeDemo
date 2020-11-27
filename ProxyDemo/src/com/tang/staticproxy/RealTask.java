package com.tang.staticproxy;

/**
 * @ClassName: RealTask
 * @author: TZL
 * @date: 2020/11/24  13:52
 * @Description: 真实的委托类，继承Task，实现处理任务的方法
 */
public class RealTask implements Task{

    /**
     * 处理任务
     * @param taskName 任务名
     */
    @Override
    public void doWork(String taskName) {
        System.out.println("正在执行任务： " + taskName);
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
