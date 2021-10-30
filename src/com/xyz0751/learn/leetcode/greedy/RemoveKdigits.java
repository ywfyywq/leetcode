package com.xyz0751.learn.leetcode.greedy;

import java.util.Stack;

/**
 * 402. 移掉 K 位数字
 *
 * 难度 中等
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 *  
 * 示例 1 ：
 *
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
 * 示例 2 ：
 *
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 ：
 *
 * 输入：num = "10", k = 2
 * 输出："0"
 * 解释：从原数字移除所有的数字，剩余为空就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= k <= num.length <= 105
 * num 仅由若干位数字（0 - 9）组成
 * 除了 0 本身之外，num 不含任何前导零
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-k-digits
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveKdigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int deleted = 0;
        for (int i=0; i<num.length();i++) {
            if (stack.isEmpty() || deleted == k) {
                stack.push(num.charAt(i));
            } else {
                while(!stack.isEmpty() && stack.peek() > num.charAt(i) && deleted < k) {
                    stack.pop();
                    deleted++;
                }
                stack.push(num.charAt(i));
            }
        }

        int remain = k-deleted;
        while(remain > 0) {
            stack.pop();
            remain--;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        while(sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveKdigits algo = new RemoveKdigits();
        System.out.println(algo.removeKdigits("112", 1));
        System.out.println(algo.removeKdigits("1432219", 3));
        System.out.println(algo.removeKdigits("10200", 1));
        System.out.println(algo.removeKdigits("10", 2));
        System.out.println(algo.removeKdigits("9", 1));
    }
}
