package com.example.sync.demo.thread;

import com.example.sync.demo.service.DemoService;

public class LockThread extends Thread {

    private DemoService demoService;

    public LockThread(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public void run() {
        demoService.lock();
    }
}
