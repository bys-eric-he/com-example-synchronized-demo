package com.example.sync.demo.thread;

/**
 * 静态方法锁修饰一个静态的方法
 */
public class StaticThread implements Runnable {
    private static int count;

    public StaticThread() {
        count = 0;
    }

    /**
     * Synchronized也可修饰一个静态方法
     * 静态方法是属于类的而不属于对象的，同样的synchronized修饰的静态方法锁定的是这个类的所有对象。
     * 即当有多个线程同时调用method方法时，
     */
    public synchronized static void method() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                System.out.println("当前线程名称->" + Thread.currentThread().getName() + " Count值:" + (count++));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public synchronized void run() {
        method();
    }
}
