package com.example.sync.demo.parent;

public class Parent {
    /**
     * 如果在父类中的某个方法使用了synchronized关键字，而在子类中覆盖了这个方法，在子类中的这个方法默认情况下并不是同步的，
     * 而必须显式地在子类的这个方法中加上synchronized关键字才可以
     */
    public synchronized void method() {
        System.out.println("这是父类method加锁方法调用!");
    }
}