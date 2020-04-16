package com.example.sync.demo.service;

public interface DemoService {
    /**
     * 打印输出
     */
    void printLine();

    /**
     * 写操作
     */
    void write();

    /**
     * 打印输出
     */
    void printing();

    /**
     * 多线程无锁读操作变量
     */
    void read();
}
