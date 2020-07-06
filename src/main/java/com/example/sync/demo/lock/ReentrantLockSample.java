package com.example.sync.demo.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock非公平锁
 * 演示可重入锁是什么意思
 */
public class ReentrantLockSample {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        //新开一条线程进行加锁
        new Thread(() -> {
            try {
                lock.lock();
                System.out.println("第1次获取锁，这个锁是：" + lock);

                int index = 1;
                while (true) {
                    try {
                        // 可重入锁就是说某个线程已经获得某个锁，可以再次获取锁而不会出现死锁,
                        // 当一个线程获取对象锁之后，这个线程可以再次获取本对象上的锁,可重入锁最大作用是避免死锁。
                        lock.lock();
                        System.out.println("第" + (++index) + "次获取锁，这个锁是：" + lock);

                        try {
                            Thread.sleep(new Random().nextInt(200));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (index == 10) {
                            break;
                        }
                    } finally {
                        // ReentrantLock 和 synchronized 不一样，需要手动释放锁，所以使用 ReentrantLock的时候一定要手动释放锁
                        // 并且加锁次数和释放次数要一样
                        // 这里如果注释，加锁次数和释放次数不一样, 就会造成死锁
                        lock.unlock();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();

        //再开一条线程并加锁
        new Thread(() -> {
            try {
                lock.lock();

                for (int i = 0; i < 20; i++) {
                    System.out.println("当前线程名称:" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(new Random().nextInt(200));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }).start();


    }
}
