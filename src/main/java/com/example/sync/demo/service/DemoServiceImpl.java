package com.example.sync.demo.service;

import org.springframework.stereotype.Service;

/**
 * 总结
 * A. 无论synchronized关键字加在方法上还是对象上，如果它作用的对象是非静态的，则它取得的锁是对象；
 * 如果synchronized作用的对象是一个静态方法或一个类，则它取得的锁是对类，该类所有的对象同一把锁。 
 * B. 每个对象只有一个锁（lock）与之相关联，谁拿到这个锁谁就可以运行它所控制的那段代码。 
 * C. 实现同步是要很大的系统开销作为代价的，甚至可能造成死锁，所以尽量避免无谓的同步控制。
 *
 * @author eric
 */
@Service
public class DemoServiceImpl implements DemoService {
    /**
     * 多线程访问变量
     */
    private volatile int counts = 0;

    /**
     * 写操作
     */
    @Override
    public void write() {
        //让synchronized锁这个类对应的Class对象,即使实例不是同一个实例也可以有效锁住，所有DemoServiceImpl实例对象公用一把锁。
        synchronized (DemoServiceImpl.class) {
            System.out.println("写线程ID:" + Thread.currentThread().getId() + " 写开始..");
            try {
                counts++;
                System.out.println("写线程ID:" + Thread.currentThread().getId() + " Counts=" + counts);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("写线程ID:" + Thread.currentThread().getId() + " 写结束..");
        }
    }

    /**
     * 读操作
     */
    @Override
    public void read() {
        System.out.println("读线程ID:" + Thread.currentThread().getId() + " 读开始..");
        try {
            System.out.println("读线程ID:" + Thread.currentThread().getId() + "读 Counts=" + counts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("读线程ID:" + Thread.currentThread().getId() + " 读结束..");
    }

    @Override
    public void printLine() {
        //让synchronized 锁这个类对象的实例，必须保证不同线程调用使用的是同一个实例才能有效锁住
        synchronized (this) {
            System.out.println("线程ID:" + Thread.currentThread().getId() + " printLine开始..");
            try {
                counts++;
                System.out.println("线程ID:" + Thread.currentThread().getId() + " Counts=" + counts);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("线程ID:" + Thread.currentThread().getId() + " printLine结束..");
        }
    }

    /**
     * 打印输出
     * synchronized修饰非静态方法时，是锁定了整个方法时的内容，等价于printLine方法体中的synchronized(this){}。
     */
    @Override
    public synchronized void printing() {
        System.out.println("线程ID:" + Thread.currentThread().getId() + " 写开始..");
        try {
            counts++;
            System.out.println("线程ID:" + Thread.currentThread().getId() + "写 Counts=" + counts);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("线程ID:" + Thread.currentThread().getId() + " 写结束..");
    }
}
