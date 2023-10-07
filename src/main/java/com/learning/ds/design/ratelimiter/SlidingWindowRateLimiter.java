package com.learning.ds.design.ratelimiter;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowRateLimiter {

    // The maximum number of requests allowed within the time window.
    private final int limit;

    // The size of the time window in seconds.
    private final int windowSeconds;

    // A map from IP addresses to the time of their last request.
    private final Map<String, Long> lastRequestTime;

    public SlidingWindowRateLimiter(int limit, int windowSeconds) {
        this.limit = limit;
        this.windowSeconds = windowSeconds;
        this.lastRequestTime = new HashMap<>();
    }

    // Checks if the given request is allowed.
    public boolean isAllowed(String ipAddress) {
        // Get the time of the last request from the map.
        Long lastRequestTime = this.lastRequestTime.get(ipAddress);

        // If there is no record for the IP address, this is the first request.
        if (lastRequestTime == null) {
            // Add the current time to the map and allow the request.
            this.lastRequestTime.put(ipAddress, System.currentTimeMillis());
            return true;
        }

        // Check if the request is within the time window.
        if (System.currentTimeMillis() - lastRequestTime < windowSeconds * 1000) {
            // The request is within the time window.
            // Check if the request exceeds the limit.
            if (this.lastRequestTime.size() >= limit) {
                // The request exceeds the limit.
                return false;
            }

            // Allow the request and update the last request time.
            this.lastRequestTime.put(ipAddress, System.currentTimeMillis());
            return true;
        }

        // The request is outside the time window.
        // Reset the last request time and allow the request.
        this.lastRequestTime.put(ipAddress, System.currentTimeMillis());
        return true;
    }
}