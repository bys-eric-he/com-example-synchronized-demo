package com.example.sync.demo.thread;

import com.example.sync.demo.service.DemoService;

public class PrintThread extends Thread {

    private DemoService demoService;

    public PrintThread(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public void run() {
        demoService.printing();
    }
}
