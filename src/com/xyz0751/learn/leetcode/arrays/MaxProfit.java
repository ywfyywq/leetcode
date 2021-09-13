package com.xyz0751.learn.leetcode.arrays;

public class MaxProfit {
    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int[] profit = new int[prices.length];
        for (int i=1; i<prices.length; i++) {
            if (prices[i] >= min) {
                profit[i] = prices[i] - min;
            } else {
                min = prices[i];
            }
        }

        int max = 0;
        for (int i=0; i<profit.length; i++) {
            if (profit[i] > max) {
                max = profit[i];
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int min = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            if (prices[i] >= min) {
                if (prices[i] - min > maxProfit) {
                    maxProfit = prices[i] - min;
                }
            } else {
                min = prices[i];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit2(new int[] {7,1,5,3,6,4}));
    }
}
