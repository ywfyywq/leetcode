package com.xyz0751.learn.leetcode.dp;

public class UniquePathsWithObstacles {
    public static int uniquePathsWithObstacless(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1] == 1) {
            return 0;
        }

        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i=0; i<obstacleGrid.length; i++) {
            for (int j=0; j<obstacleGrid[i].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                    continue;
                }

                if(i==0) {
                    if (j==0) {
                        paths[i][j] = 1;
                    } else {
                        paths[i][j] = paths[i][j-1];
                    }
                } else if(j==0){
                    if (i==0) {
                        paths[i][j] = 1;
                    } else {
                        paths[i][j] = paths[i-1][j];
                    }
                } else {
                    if(obstacleGrid[i-1][j] == 1 && obstacleGrid[i][j-1] == 1) {
                        paths[i][j] = 0;
                    } else if (obstacleGrid[i-1][j] == 1) {
                        paths[i][j] = paths[i][j-1];
                    } else if (obstacleGrid[i][j-1] == 1) {
                        paths[i][j] = paths[i-1][j];
                    } else {
                        paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                    }
                }
            }
        }

        return paths[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsWithObstacless(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(uniquePathsWithObstacless(new int[][]{{0,0},{0,1}}));
    }
}
