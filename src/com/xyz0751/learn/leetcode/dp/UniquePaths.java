package com.xyz0751.learn.leetcode.dp;

/**
 * 62. 不同路径
 *
 * 难度 中等
 *
 * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 *
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 *
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 *
 * 输入：m = 3, n = 3
 * 输出：6
 *
 * @author YY
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        if (m==1 || n==1) {
            return 1;
        }

        int[][] paths = new int[m][n];

        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if(i==0 || j==0) {
                    paths[i][j] = 1;
                } else {
                    paths[i][j] = paths[i-1][j] + paths[i][j-1];
                }
            }
        }

        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }
}
