package com.xyz0751.learn.leetcode.dp;

/**
 * 64. 最小路径和
 *
 * 难度 中等
 *
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 *
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * YY
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 *
 * @author YY
 */
public class MinPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 || n == 1) {
            int min = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    min += grid[i][j];
                }
            }
            return min;
        }

        int[][] minPathSums = new int[m][n];
        minPathSums[0][0] = grid[0][0];
        for (int i=1; i<m; i++) {
            minPathSums[i][0] = minPathSums[i-1][0] + grid[i][0];
        }

        for (int i=1; i<n; i++) {
            minPathSums[0][i] = minPathSums[0][i-1] + grid[0][i];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (minPathSums[i-1][j] < minPathSums[i][j-1]) {
                    minPathSums[i][j] = minPathSums[i-1][j] + grid[i][j];
                } else {
                    minPathSums[i][j] = minPathSums[i][j-1] + grid[i][j];
                }
            }
        }

        return minPathSums[m-1][n-1];
    }

    public static void main(String[] args) {
//        System.out.println(minPathSum(new int[][]{{1, 3, 1},{1, 5, 1},{4, 2, 1}}));
        System.out.println(minPathSum(new int[][]{{1, 2, 3},{4, 5, 6}}));
    }
}
