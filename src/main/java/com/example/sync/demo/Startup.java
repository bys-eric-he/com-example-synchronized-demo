package com.example.sync.demo;

import com.example.sync.demo.service.DemoService;
import com.example.sync.demo.thread.PrintThread;
import com.example.sync.demo.thread.ReadThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements CommandLineRunner {
    @Autowired
    public DemoService demoService;

    @Override
    public void run(String... args) throws Exception {
        try {
            for (int i = 0; i < 3; i++) {
                //写操作线程
                Thread printThread = new PrintThread(demoService);
                printThread.start();

                //读操作线程
                Thread addingThread = new ReadThread(demoService);
                addingThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
