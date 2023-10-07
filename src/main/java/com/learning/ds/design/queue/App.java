package com.learning.ds.design.queue;

public class App {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new BlockingQueue<>(5);
        blockingQueue.put(1);
        blockingQueue.put(2);
        blockingQueue.put(3);
        blockingQueue.put(4);
        System.out.println(blockingQueue.take());
    }
}
