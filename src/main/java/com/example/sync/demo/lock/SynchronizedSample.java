package com.example.sync.demo.lock;

/**
 * 演示可重入锁是什么意思，可重入，就是可以重复获取相同的锁，synchronized和ReentrantLock都是可重入的
 * 可重入降低了编程复杂性
 */
public class SynchronizedSample {
    public static void main(String[] args) {
        //新开一条线程进行加锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    System.out.println("第1次获取锁，这个锁是：" + this);
                    int index = 1;
                    while (true) {
                        // 可重入锁就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁,
                        // 当一个线程获取对象锁之后，这个线程可以再次获取本对象上的锁,可重入锁最大作用是避免死锁。
                        synchronized (this) {
                            System.out.println("第" + (++index) + "次获取锁，这个锁是：" + this);
                        }
                        if (index == 10) {
                            break;
                        }
                    }
                }
            }
        }).start();
    }
}
