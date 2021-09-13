package com.xyz0751.learn.leetcode.dp;

import java.util.Arrays;

public class NumSquares {
    public static int numSquares(int n) {
        int sqrt = (int)Math.sqrt(n);
        if (sqrt*sqrt == n) {
            return 1;
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int maxSqure = sqrt + 1;
        int[]squareNums = new int[maxSqure];
        for (int i = 1; i < maxSqure; ++i) {
            squareNums[i] = i * i;
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<maxSqure; j++) {
                if (i < squareNums[j]) {
                    break;
                }
                dp[i] = Math.min(dp[i], dp[i-squareNums[j]] +1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numSquares(16));
    }
}
