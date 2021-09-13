package com.xyz0751.learn.leetcode.dp;

public class MaxProfit {

    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[prices.length-1] = 0;

        int max = 0;
        for (int i=prices.length-2; i>=0; i--) {
            for (int j=prices.length-1; j>i; j--) {
                if (prices[j] > prices[i]) {
                    if (j+2<prices.length) {
                        dp[i] = Math.max(prices[j] - prices[i] + dp[j + 2], dp[i]);
                    } else {
                        dp[i] = Math.max(prices[j] - prices[i], dp[i]);
                    }
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public int maxProfit2(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }

        if (prices.length == 2) {
            if (prices[1] - prices[0] > 0) {
                return prices[1] - prices[0];
            } else {
                return 0;
            }
        }

        return maxProfit2(0, prices);
    }

    public int maxProfit2(int start, int[] prices) {
        int max = 0;
        if (start >= prices.length-1) {
            return 0;
        }

        for (int i=start; i<prices.length; i++) {
            int tempMax = 0;
            for (int j=i+1; j<prices.length; j++) {
                if (prices[j] > prices[i]) {
                    tempMax = prices[j] - prices[i];
                    tempMax += maxProfit2(j+2, prices);
                    max = Math.max(tempMax, max);
                }
            }

        }
        return max;
    }


    public static void main(String[] args) {
        MaxProfit mp = new MaxProfit();
        System.out.println(mp.maxProfit(new int[] {1,2,3,0,2}));
    }
}
