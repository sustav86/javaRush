package com.javarush.test.level30.lesson04.home01;

import java.util.concurrent.TransferQueue;

/**
 * Created by ukr-sustavov on 28.12.2016.
 */
public class Producer implements Runnable {
    private TransferQueue<ShareItem> shareItem;

    public Producer(TransferQueue<ShareItem> shareItem) {
        this.shareItem = shareItem;
    }

    @Override
    public void run() {
        for (int i = 1; i < 10; i++) {
            final int j = i;
            System.out.format("Элемент 'ShareItem-%s' добавлен \n", j);
            shareItem.offer(new ShareItem("ShareItem-" + j, j));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                e.printStackTrace();
            }
            if (shareItem.getWaitingConsumerCount() > 0) {
                System.out.println("Consumer в ожидании!");
            }

        }
    }
}
