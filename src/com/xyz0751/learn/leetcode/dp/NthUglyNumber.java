package com.xyz0751.learn.leetcode.dp;

/**
 * 264. 丑数 II
 * 难度 中等
 *
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 *
 * 丑数 就是只包含质因数2、3 和/或5的正整数。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：n = 10
 * 输出：12
 * 解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：1
 * 解释：1 通常被视为丑数。
 * 
 *
 * 提示：
 *
 * 1 <= n <= 1690
 *
 */
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
