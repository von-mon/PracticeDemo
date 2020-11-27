package com.tang.store;

/**
 * @ClassName: Store
 * @author: TZL
 * @date: 2020/11/26  17:32
 * @Description: 生产者消费者问题
 */
public class Store {
    private static final int MAX_PRODUCT = 10;
    private static final int MIN_PRODUCT = 0;
    private static int product;
    private static final Object object = new Object();

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread produce = new Produce();
            Thread consume = new Consume();
            consume.start();
            produce.start();
        }

    }

    static class Produce extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                if (product >= MAX_PRODUCT) {
                    try {
                        System.out.println("your product has reached maximum.");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    product++;
                    System.out.println("you produce one product. There are " + product + " product");
                    object.notify();
                }
            }
        }

    }

    static class Consume extends Thread {

        @Override
        public void run() {
            synchronized (object) {
                if (product <= MIN_PRODUCT) {
                    try {
                        System.out.println("Sorry, All product has been sell!!!Please wait,thank you.");
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    product--;
                    System.out.println("consumer take one product. There are " + product + " product");
                    object.notify();
                }

            }
        }
    }
}
