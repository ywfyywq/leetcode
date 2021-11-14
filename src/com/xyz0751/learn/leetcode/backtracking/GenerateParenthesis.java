package com.xyz0751.learn.leetcode.backtracking;

import java.util.*;

/**
 * 22. 括号生成
 *
 * 难度 中等
 *
 * 数字 n   代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *
 *    
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *    
 *
 * 提示：
 *
 * 1 <= n <= 8
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        Set<String> set = new HashSet<>();
        backtracking(set, n, 0, "");
        return new ArrayList<>(set);
    }

    public void backtracking(Set<String> set, int left, int right, String temp) {
        if (left == 0) {
            while(right-- > 0) {
                temp += ")";
            }
            set.add(temp);
            return;
        }

        if (right == 0) {
            backtracking(set, left-1, right+1, temp+"(");
        } else {
            backtracking(set, left-1, right+1, temp+"(");
            backtracking(set, left, right-1, temp+")");
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis algo = new GenerateParenthesis();
        System.out.println(algo.generateParenthesis(4));
    }
}
