package com.xyz0751.learn.leetcode.binarysearch;

/**
 * 74. 搜索二维矩阵
 *
 * 难度 中等
 *
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 *  
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][matrix[i].length-1]) {
                int l = 0;
                int r = matrix[i].length-1;
                while(l<=r) {
                    int mid = l+(r-l)/2;
                    if (matrix[i][mid] == target) {
                        return true;
                    } else if (matrix[i][mid] < target) {
                        l = mid+1;
                    } else {
                        r = mid-1;
                    }
                }
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix algo = new SearchMatrix();
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 3));
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 10));
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 60));
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 16));
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 30));
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 23));
        System.out.println(algo.searchMatrix(new int[][]{ {1,3,5,7 }, {10,11,16,20 }, {23,30,34,60 }}, 13));
    }
}
