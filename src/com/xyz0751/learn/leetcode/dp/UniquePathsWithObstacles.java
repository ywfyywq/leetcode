package com.xyz0751.learn.leetcode.dp;

/**
 * 63. 不同路径 II
 *
 * 难度 中等
 *
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 *
 *
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 *
 *
 * 提示：
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 *
 * @author YY
 */
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
