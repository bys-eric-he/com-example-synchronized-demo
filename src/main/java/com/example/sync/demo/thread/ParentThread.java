package com.example.sync.demo.thread;

import com.example.sync.demo.parent.Child;

public class ParentThread implements Runnable {

    private Child child;

    public ParentThread(Child child) {
        this.child = child;
    }

    @Override
    public void run() {
        child.method();
        child.callSuperMethod();
    }
}
