package com.xyz0751.learn.leetcode.dp;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount+1];
        Arrays.fill(dp, -1);
        for (int i=1; i<=amount; i++) {
            int count = Integer.MAX_VALUE;
            for (int j=0; j<coins.length; j++) {
                if (coins[j] == i) {
                    if (count > 0) {
                        count = Math.min(1, count);
                    } else {
                        count = 1;
                    }
                    break;
                } else if (coins[j] < i){
                    if (dp[i-coins[j]] > 0) {
                        count = Math.min(dp[i-coins[j]] + 1, count);
                    }
                }
            }
            dp[i] = count == Integer.MAX_VALUE ? -1 : count;
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        System.out.println(cc.coinChange(new int[]{186,419,83,408}, 6249));
    }
}
