package com.learning.ds.design.ratelimiter;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

public class SlidingWindow implements RateLimiter{

    private Queue<Long> slidingWindow;
    private int timeWindowsInSecods;
    private int bucketCapacity;

    public SlidingWindow(int timeWindowsInSecods, int bucketCapacity) {
        this.timeWindowsInSecods = timeWindowsInSecods;
        this.bucketCapacity = bucketCapacity;
        this.slidingWindow = new ConcurrentLinkedDeque<>();
    }

    @Override
    public boolean grantAccess() {
        long currentTime = System.currentTimeMillis();
        checkAndUpdateQueue(currentTime);
        if(slidingWindow.size() < bucketCapacity) {
            slidingWindow.offer(currentTime);
            return true;
        }
        return false;
    }

    private void checkAndUpdateQueue(long currentTime) {
        if(slidingWindow.isEmpty())
            return;

        long calculatedTime = (currentTime - slidingWindow.peek())/1000;

        while (calculatedTime >= timeWindowsInSecods) {
            slidingWindow.poll();
            if(slidingWindow.isEmpty())
                break;
            calculatedTime = (currentTime - slidingWindow.peek())/1000;
        }
    }
}
