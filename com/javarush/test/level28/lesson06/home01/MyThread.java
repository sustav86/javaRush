package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ukr-sustavov on 22.12.2016.
 */
public class MyThread extends Thread {

    private static AtomicInteger threadPriority = new AtomicInteger(1);

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        setPriority();
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        setPriority();
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        setPriority();
    }

    public MyThread() {
        setPriority();
    }

    private void setPriority() {
        if (threadPriority.get() == 10) {
            this.setPriority(threadPriority.getAndSet(1));
        } else {
            this.setPriority(threadPriority.getAndIncrement());
        }

    }
}
