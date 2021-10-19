package com.xyz0751.learn.leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 409. 最长回文串
 *
 * 难度 中等
 *
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 *
 * 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。
 *
 * 注意:
 * 假设字符串的长度不会超过 1010。
 *
 * 示例 1:
 *
 * 输入:
 * "abccccdd"
 *
 * 输出:
 * 7
 *
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 *
 * @author YY
 *
 */
public class LongestPalindrome {

    /**
     * 贪心解法-官方题解
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


    /**
     * mine
     * @param s
     * @return
     */
    public int longestPalindrome2(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        for (int i=0; i<s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                max+=2;
                set.remove(s.charAt(i));
            } else {
                set.add(s.charAt(i));
            }
        }

        if (set.size() > 0) {
            max++;
        }

        return max;
    }

    public int longestPalindrome3(String s) {
        int[] count = new int[128];
        int length = s.length();
        int ans = 0;
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            if ((count[c] & 1) == 1) {
                ans+=2;
            }
            count[c]++;
        }
        if (ans < s.length()) {
            ans++;
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome3("abccccdd"));
    }
}
