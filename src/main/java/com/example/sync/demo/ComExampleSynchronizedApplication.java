package com.example.sync.demo;

import com.example.sync.demo.model.Account;
import com.example.sync.demo.parent.Child;
import com.example.sync.demo.service.DemoService;
import com.example.sync.demo.service.DemoServiceImpl;
import com.example.sync.demo.thread.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComExampleSynchronizedApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComExampleSynchronizedApplication.class, args);

        //必须保证每个线程使用的是同一个对象 synchronized(this)才有效
        DemoService demoService = new DemoServiceImpl();
        for (int i = 0; i < 3; i++) {
            Thread thread = new WriteThread(demoService);
            thread.start();
        }

        for (int i = 0; i < 3; i++) {
            Thread thread = new PrintThread(demoService);
            thread.start();
        }

        for (int i = 0; i < 3; i++) {
            StaticThread staticThread = new StaticThread();
            Thread thread = new Thread(staticThread, "SyncThread" + i);
            thread.start();
        }

        Account account = new Account("eric he", 10000.0f);
        AccountOperatorThread accountOperator = new AccountOperatorThread(account);

        final int THREAD_NUM = 5;
        Thread[] threads = new Thread[THREAD_NUM];
        for (int i = 0; i < THREAD_NUM; i++) {
            threads[i] = new Thread(accountOperator, "Thread" + i);
            threads[i].start();
        }

        Child child = new Child();
        ParentThread parentThread = new ParentThread(child);
        Thread thread = new Thread(parentThread, "ParentThread");
        thread.start();

        for (int i = 0; i < 2; i++) {
            Thread lockThread = new LockThread(demoService);
            lockThread.start();
        }
    }
}
