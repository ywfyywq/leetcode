package com.xyz0751.learn.leetcode.dp;

/**
 * 397. 整数替换
 *
 * 难度 中等
 *
 * 给定一个正整数 n ，你可以做如下操作：
 *
 * 如果 n 是偶数，则用 n / 2替换 n 。
 * 如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
 * n 变为 1 所需的最小替换次数是多少？
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 8
 * 输出：3
 * 解释：8 -> 4 -> 2 -> 1
 * 示例 2：
 *
 * 输入：n = 7
 * 输出：4
 * 解释：7 -> 8 -> 4 -> 2 -> 1
 * 或 7 -> 6 -> 3 -> 2 -> 1
 * 示例 3：
 *
 * 输入：n = 4
 * 输出：2
 *  
 *
 * 提示：
 *
 * 1 <= n <= 231 - 1
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-replacement
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerReplacement {
    public int integerReplacement2(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int[] dp = new int[3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        int index = 2;
        for ( int i=3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = 1 + dp[i / 2];
                if (i / 2 == index) {

                }
            } else {
                dp[i] = Math.min(dp[(i-1)/2]+1, dp[(i+1)/2]+2);
            }
        }
        return dp[n];
    }

    public int integerReplacement(int n) {
        int count = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                count++;
                n /= 2;
            } else if (n % 4 == 1) {
                n = n/2;
                count += 2;
            } else{
                if (n == 3) {
                    count += 2;
                    n = 1;
                } else {
                    n = n/2+1;
                    count += 2;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        IntegerReplacement algo = new IntegerReplacement();
        System.out.println(algo.integerReplacement(2147483647));
        System.out.println(algo.integerReplacement(8));
        System.out.println(algo.integerReplacement(7));
        System.out.println(algo.integerReplacement(4));
    }
}
