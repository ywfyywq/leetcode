package com.xyz0751.learn.leetcode.greedy;

/**
 * 1323. 6 和 9 组成的最大数字
 *
 * 难度 简单
 *
 * 给你一个仅由数字 6 和 9 组成的正整数  num。
 *
 * 你最多只能翻转一位数字，将 6 变成  9，或者把  9 变成  6 。
 *
 * 请返回你可以得到的最大数字。
 *
 *   
 *
 * 示例 1：
 *
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * 示例 2：
 *
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * 示例 3：
 *
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-69-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Maximum69Number {
    public int maximum69Number (int num) {
        String nums = num+"";
        int index = nums.indexOf("6");
        if (index != -1) {
            if (index == 0) {
                return Integer.parseInt("9" + nums.substring(1));
            } else if (index == nums.length()-1) {
                return Integer.parseInt(nums.substring(0, nums.length()-1) +"9");
            } else {
                return Integer.parseInt(nums.substring(0, index) + "9" + nums.substring(index+1));
            }
        }

        return num;
    }

    public int maximum69Number2 (int num) {
        String nums = num+"";
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for (int i=0; i<nums.length(); i++) {
            if (!found && nums.charAt(i) == '6') {
                sb.append('9');
                found = true;
            } else {
                sb.append(nums.charAt(i));
            }
        }

        return Integer.parseInt(sb.toString());
    }

    public int maximum69Number3 (int num) {
        return Integer.parseInt((num+"").replaceFirst("6", "9"));
    }

    public static void main(String[] args) {
        Maximum69Number algo = new Maximum69Number();
        System.out.println(algo.maximum69Number3(6669));
        System.out.println(algo.maximum69Number3(9999));
    }
}
