package com.xyz0751.learn.leetcode.strings;

/**
 * 1446. 连续字符
 *
 * 难度 简单
 *
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 *
 * 请你返回字符串的能量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 * 示例 2：
 *
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 * 示例 3：
 *
 * 输入：s = "triplepillooooow"
 * 输出：5
 * 示例 4：
 *
 * 输入：s = "hooraaaaaaaaaaay"
 * 输出：11
 * 示例 5：
 *
 * 输入：s = "tourist"
 * 输出：1
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/consecutive-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxPower {
    public int maxPower(String s) {
        int max = 1;
        int temp = 1;
        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i-1) == s.charAt(i)) {
                temp++;
                max = Math.max(max, temp);
            } else {
                temp = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaxPower algo = new MaxPower();
        System.out.println(algo.maxPower("leetcode"));
        System.out.println(algo.maxPower("abbcccddddeeeeedcba"));
        System.out.println(algo.maxPower("triplepillooooow"));
        System.out.println(algo.maxPower("hooraaaaaaaaaaay"));
        System.out.println(algo.maxPower("tourist"));
    }
}
