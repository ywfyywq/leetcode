package com.xyz0751.learn.leetcode.dp;

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
