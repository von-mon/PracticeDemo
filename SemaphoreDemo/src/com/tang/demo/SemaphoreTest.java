package com.tang.demo;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @ClassName: SemaphoreTest
 * @author: TZL
 * @date: 2020/11/30  14:04
 * @Description: 信号量
 */
public class SemaphoreTest {

    public static void main(String[] args) {
        //开始一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        //定义一个信号量
        final Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 20; i++) {
            Runnable runnable = () -> {
                try {
                    semaphore.acquire();
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "，已存在" + (5 - semaphore.availablePermits()) + "个");
                    Thread.sleep(new Random().nextInt(1000) * 10);
                    System.out.println("即将离开的线程：" + Thread.currentThread().getName());
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
            executorService.execute(runnable);
        }
        executorService.shutdown();
    }
}
