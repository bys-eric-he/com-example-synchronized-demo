package com.example.sync.demo.thread;

import com.example.sync.demo.service.DemoService;

public class ReadThread extends Thread {

    private DemoService demoService;

    public ReadThread(DemoService demoService) {
        this.demoService = demoService;
    }

    @Override
    public void run() {
        demoService.read();
    }
}
