package com.xyz0751.learn.leetcode.dp;

import java.util.Arrays;

/**
 * 279. 完全平方数
 * 难度 中等
 *
 * 给定正整数n，找到若干个完全平方数（比如1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * 
 *
 * 示例1：
 *
 * 输入：n = 12
 * 输出：3
 * 解释：12 = 4 + 4 + 4
 * 示例 2：
 *
 * 输入：n = 13
 * 输出：2
 * 解释：13 = 4 + 9
 * 
 * 提示：
 *
 * 1 <= n <= 104
 *
 */
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
