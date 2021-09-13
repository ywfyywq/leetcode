package com.xyz0751.learn.leetcode.dp;

public class NthUglyNumber {
    public static int nthUglyNumber(int n) {
        if (n==1) {
            return 1;
        }

        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i=2; i<=n; i++) {
            dp[i] = Math.min(dp[p2]*2, Math.min(dp[p3]*3, dp[p5]*5));
            if (dp[i] == dp[p2]*2) {
                p2++;
            }
            if (dp[i] == dp[p3]*3) {
                p3++;
            }
            if (dp[i] == dp[p5]*5){
                p5++;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(20));
    }
}
