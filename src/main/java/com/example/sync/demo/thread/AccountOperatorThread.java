package com.example.sync.demo.thread;

import com.example.sync.demo.model.Account;

/**
 * 账户操作类
 */
public class AccountOperatorThread implements Runnable {
    private Account account;

    public AccountOperatorThread(Account account) {
        this.account = account;
    }

    /**
     * 在AccountOperator 类中的run方法里，我们用synchronized 给account对象加了锁。
     * 这时，当一个线程访问account对象时，其他试图访问account对象的线程将会阻塞，直到该线程访问account对象结束。
     * 也就是说谁拿到那个锁谁就可以运行它所控制的那段代码。 
     * 当有一个明确的对象作为锁时，就可以用类似下面这样的方式写程序。
     */
    public void run() {
        //account锁定的对象
        synchronized (account) {
            account.deposit(500);
            account.withdraw(500);
            System.out.println("当前账户操作线程->" + Thread.currentThread().getName() + "银行卡余额:" + account.getBalance());
        }
    }
}