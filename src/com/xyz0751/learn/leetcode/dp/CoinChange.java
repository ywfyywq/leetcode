package com.xyz0751.learn.leetcode.dp;

import java.util.Arrays;

/**
 * 322. 零钱兑换
 * 难度 中等
 *
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 *
 * 
 *
 * 示例1：
 *
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3 
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 *
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 *
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 *
 * 输入：coins = [1], amount = 2
 * 输出：2
 * 
 *
 * 提示：
 *
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 *
 * @author YY
 */
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
