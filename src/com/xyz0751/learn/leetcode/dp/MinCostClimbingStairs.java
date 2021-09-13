package com.xyz0751.learn.leetcode.dp;

public class MinCostClimbingStairs {

    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length == 1) {
            return cost[0];
        } else if(cost.length == 2) {
            return cost[0] < cost[1] ? cost[0] : cost[1];
        }

        int preCost = cost[0];
        int currentCost = cost[1];
        int temp;
        for (int i = 2; i<cost.length; i++) {
            if (preCost < currentCost) {
                temp = currentCost;
                currentCost = preCost + cost[i];
                preCost = temp;
            } else {
                preCost = currentCost;
                currentCost += cost[i];
            }
        }

        return preCost < currentCost ? preCost : currentCost;
    }

    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs(new int[]{10, 15, 20}));
        System.out.println(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(minCostClimbingStairs(new int[]{1,0,0,1}));
    }
}
