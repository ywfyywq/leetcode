package com.xyz0751.learn.leetcode.dp;

/**
 * 121. 买卖股票的最佳时机
 *
 * 难度 中等
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *  
 *
 * 提示：
 *
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * 309. 最佳买卖股票时机含冷冻期
 *
 * 给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 示例:
 *
 * 输入: [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 *
 *
 * @author YY
 */
public class MaxProfit {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        int f0 = -prices[0];
        int f1 = 0;
        int f2 = 0;
        for (int i = 1; i < n; ++i) {
            int newf0 = Math.max(f0, f2 - prices[i]);
            int newf1 = f0 + prices[i];
            int newf2 = Math.max(f1, f2);
            f0 = newf0;
            f1 = newf1;
            f2 = newf2;
        }

        return Math.max(f1, f2);
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
