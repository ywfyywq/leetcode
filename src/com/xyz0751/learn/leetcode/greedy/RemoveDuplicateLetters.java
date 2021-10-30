package com.xyz0751.learn.leetcode.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 316. 去除重复字母
 *
 * 难度 中等
 *
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 *
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 *  
 *
 * 提示：
 *
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i) - 'a']++;
        }
        List<Character> list = new ArrayList<>();
        for (int i=0; i<s.length(); i++) {
            Character c = s.charAt(i);
            if (!list.contains(c)) {
                while (list.size() > 0 && list.get(list.size() - 1) > c) {
                    if (num[list.get(list.size() - 1) - 'a'] > 0) {
                        list.remove(list.size()-1);
                    } else {
                        break;
                    }
                }
                list.add(c);
            }
            num[c - 'a'] -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters rd = new RemoveDuplicateLetters();
        System.out.println(rd.removeDuplicateLetters("rusrbofeggbbkyuyjsrzornpdguwzizqszpbicdquakqws"));
        System.out.println(rd.removeDuplicateLetters("beeaddbeb"));
        System.out.println(rd.removeDuplicateLetters("bcabc"));
        System.out.println(rd.removeDuplicateLetters("cbacdcbc"));
    }
}
