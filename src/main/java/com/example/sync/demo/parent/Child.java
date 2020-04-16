package com.example.sync.demo.parent;

public class Child extends Parent {
    /**
     * synchronized关键字不能继承。 重写父类带synchronized方法，必须显式地在子类的这个方法中加上synchronized关键字才可以。
     */
    @Override
    public synchronized void method() {
        System.out.println("这是子类重写父类的带synchronized method方法!");
    }

    /**
     * 可以在子类方法中调用父类中带synchronized的方法，这样虽然子类中的方法不是同步的，但子类调用了父类的同步方法。
     * 因此，子类的方法也就相当于同步了。
     */
    public void callSuperMethod() {
        super.method();
    }
}