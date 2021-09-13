package com.xyz0751.learn.leetcode.dp;

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
