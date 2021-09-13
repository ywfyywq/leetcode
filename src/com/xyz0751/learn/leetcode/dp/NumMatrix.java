package com.xyz0751.learn.leetcode.dp;

public class NumMatrix {
    int[][] dp = null;
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        dp = new int[m][n];
        dp[0][0] = matrix[0][0];
        for (int i=1; i<m; i++) {
            dp[i][0] = dp[i-1][0] + matrix[i][0];
        }

        for (int i=1; i<n; i++) {
            dp[0][i] = dp[0][i-1] + matrix[0][i];
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int leftDownCorner = 0;
        int rightUpConer = 0;
        int leftUpConer = 0;
        if (col1 > 0) {
            leftDownCorner = dp[row2][col1-1];
        }
        if (row1 > 0) {
            rightUpConer = dp[row1-1][col2];
        }

        if (row1 > 0 && col1 > 0) {
            leftUpConer = dp[row1-1][col1-1];
        }
        return dp[row2][col2] - leftDownCorner - rightUpConer + leftUpConer;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(0, 0, 2, 4));
    }

}
