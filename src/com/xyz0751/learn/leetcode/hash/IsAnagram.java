package com.xyz0751.learn.leetcode.hash;

import java.util.Arrays;

/**
 * 242. 有效的字母异位词
 *
 * 难度 简单
 *
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 *  
 *
 * 提示:
 *
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sc = new int[26];
        for (int i=0; i<s.length(); i++) {
            sc[s.charAt(i)-'a']++;
        }
        int[] tc = new int[26];
        for (int i=0; i<t.length(); i++) {
            tc[t.charAt(i)-'a']++;
        }

        return Arrays.equals(sc, tc);
    }

    public static void main(String[] args) {
        IsAnagram algo = new IsAnagram();
        System.out.println(algo.isAnagram("anagram", "nagaram"));
        System.out.println(algo.isAnagram("rat", "car"));
    }
}
