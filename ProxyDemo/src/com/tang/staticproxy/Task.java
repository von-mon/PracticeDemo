package com.tang.staticproxy;

/**
 * @ClassName: Task
 * @author: TZL
 * @date: 2020/11/24  13:50
 * @Description: 代理接口
 */
public interface Task {

    /**
     * 处理任务
     * @param taskName 任务名
     */
    void doWork(String taskName);
}
