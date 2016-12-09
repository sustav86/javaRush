package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        while (!thread.isInterrupted()) {
            try {
                thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (thread.getState() == Thread.State.RUNNABLE) {
                System.out.println(thread.getName());
            }
            try {
                thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this);
        thread.setName(threadName);
        thread.start();

    }

    @Override
    public void stop() {
        thread.interrupt();
    }

}
