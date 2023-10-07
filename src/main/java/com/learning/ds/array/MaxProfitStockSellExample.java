package com.learning.ds.array;

// https://www.youtube.com/watch?v=34WE6kwq49U&ab_channel=AnujBhaiya
// Leetcode - 121
public class MaxProfitStockSellExample {

    public static void main(String[] args) {

        int [] stockPriceOnADay = {2, 4, 7, 1, 8, 9, 12};

        getMaxProfit(stockPriceOnADay);

        getMaxProfitInEffectiveWay(stockPriceOnADay);
    }

    private static void getMaxProfitInEffectiveWay(int[] stockPriceOnADay) {
        int minSoFar = 0;
        int maxProfit = 0;

        for(int i=0; i<stockPriceOnADay.length; i++){
            minSoFar = Math.min(stockPriceOnADay[i], minSoFar);
            int profit = stockPriceOnADay[i] - minSoFar;
            maxProfit = Math.max(maxProfit, profit);
        }

        System.out.println("Max profit " + maxProfit);
    }

    private static void getMaxProfit(int [] prices) {
        // Get max price from future (right side)
        int auxArr[] = new int[prices.length];
        int max = 0;
        for(int i=prices.length-1; i>=0; i--){
            max = Math.max(prices[i], max);
            auxArr[i] = max;
        }
        max = 0;
        for(int i=0; i<prices.length; i++){
            max = Math.max(auxArr[i] - prices[i], max);
        }
        System.out.println("Maxium profit made " + max);

    }
}
