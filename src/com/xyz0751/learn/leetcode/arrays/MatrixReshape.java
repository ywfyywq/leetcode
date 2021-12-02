package com.xyz0751.learn.leetcode.arrays;

/**
 * 566. 重塑矩阵
 *
 * 难度 简单
 *
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 *
 * 给你一个由二维数组 mat 表示的m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 *
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 *
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 
 *
 * 示例 1：
 *
 *
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * 示例 2：
 *
 *
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * 
 *
 * 提示：
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reshape-the-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (mat.length * mat[0].length != r*c) {
            return mat;
        }

        int[][] newMat = new int[r][c];
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                int seq = (i*c + j);
                int i1 = seq/mat[0].length;
                int j1 = seq%mat[0].length;
                newMat[i][j] = mat[i1][j1];
            }
        }

        return newMat;
    }

    public static void main(String[] args) {
        MatrixReshape algo = new MatrixReshape();
        algo.matrixReshape(new int[][]{{1,2},{3,4}}, 4, 1);
        algo.matrixReshape(new int[][]{{1,2, 3,4}}, 2, 2);
    }
}
