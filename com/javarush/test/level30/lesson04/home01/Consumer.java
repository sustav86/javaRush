package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by ukr-sustavov on 28.12.2016.
 */
public class Consumer implements Runnable {
    private TransferQueue<ShareItem> shareItem;

    public Consumer(TransferQueue<ShareItem> shareItem) {
        this.shareItem = shareItem;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                ShareItem item = shareItem.take();
                System.out.println("Processing " + item.toString());
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
        }

    }
}
