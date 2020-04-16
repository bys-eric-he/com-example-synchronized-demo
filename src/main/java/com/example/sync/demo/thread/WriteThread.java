package com.example.sync.demo.thread;

import com.example.sync.demo.service.DemoService;

public class WriteThread extends Thread {

    private DemoService demoService;

    public WriteThread(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public void run() {
        demoService.write();
    }
}
