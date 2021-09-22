package com.xyz0751.learn.leetcode.dp;

/**
 * 91. 解码方法
 *
 * 难度 中等
 *
 * 一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 *
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 *
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 *
 * 题目数据保证答案肯定是一个 32 位 的整数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 *
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 *
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 *
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * @author YY
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.startsWith("0")) {
            return 0;
        }

        if (s.length() == 1) {
            if (s.compareTo("1")>=0 && s.compareTo("9")<=0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            if (s.charAt(0) <'1' || s.charAt(0) > '9') {
                return 0;
            }
        }

        int[] dp1 = new int[s.length()];
        int[] dp2 = new int[s.length()];

        dp1[0] = 1;
        dp2[0] = 0;
        for (int i=1; i<s.length(); i++) {
            char preChar = s.charAt(i-1);
            char currentChar = s.charAt(i);
            if (currentChar >='1' && currentChar <= '9') {
                dp1[i] = dp1[i-1] + dp2[i-1];
            }

            if (dp1[i-1] > 0) {
                if (currentChar == '0' && (preChar == '1' || preChar == '2')) {
                    dp1[i] = 0;
                    dp2[i] = dp1[i-1];
                } else if(currentChar>='1') {
                    if (currentChar<='6') {
                        if (preChar == '1' || preChar == '2') {
                            dp2[i] = dp1[i-1];
                        }
                    } else if (currentChar>'6' && currentChar <='9') {
                        if (preChar == '1') {
                            dp2[i] = dp1[i-1];
                        }
                    }
                }
            }

            if (dp1[i] == 0 && dp2[i] == 0) {
                return 0;
            }
        }

        return dp1[s.length()-1] + dp2[s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("12"));
        System.out.println(numDecodings("226"));
        System.out.println(numDecodings("22630"));
        System.out.println(numDecodings("06"));
    }
}
