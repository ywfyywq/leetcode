package com.xyz0751.learn.leetcode.maths;

/**
 * 400. 第 N 位数字
 *
 * 难度 中等
 *
 * 给你一个整数 n ，请你在无限的整数序列   [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...] 中找出并返回第   n 位上的数字。
 *
 *    
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：3
 * 示例 2：
 *
 * 输入：n = 11
 * 输出：0
 * 解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
 *    
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 * 第 n 位上的数字是按计数单位（digit）从前往后数的第 n 个数，参见 示例 2 。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nth-digit
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNthDigit {
    public int findNthDigit(int n) {
        int d = 1, count = 9;
        while (n > (long) d * count) {
            n -= d * count;
            d++;
            count *= 10;
        }
        int index = n - 1;
        int start = (int) Math.pow(10, d - 1);
        int num = start + index / d;
        int digitIndex = index % d;
        int digit = (num / (int)(Math.pow(10, d - digitIndex - 1))) % 10;
        return digit;
    }

    public static void main(String[] args) {
        FindNthDigit algo = new FindNthDigit();
        System.out.println(algo.findNthDigit(11));
    }
}
