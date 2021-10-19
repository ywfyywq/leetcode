package com.xyz0751.learn.leetcode.greedy;

/**
 * 680. 验证回文字符串 Ⅱ
 *
 * 难度 简单
 *
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: s = "aba"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "abca"
 * 输出: true
 * 解释: 你可以删除c字符。
 * 示例 3:
 *
 * 输入: s = "abc"
 * 输出: false
 *
 *
 * 提示:
 *
 * 1 <= s.length <= 105
 * s 由小写英文字母组成
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindrome {

    public boolean validPalindrome(String s) {
        return validPalindrome(s, 1);
    }

    public boolean validPalindrome(String s, int maxDeleted) {
        int i=0, j=s.length()-1;
        int deleted = 0;
        while (i<j) {
            if (s.charAt(i) != s.charAt(j)) {
                deleted++;
                if (deleted <= maxDeleted) {
                    if (i+1 < j) {
                        if (s.charAt(i + 1) == s.charAt(j)) {
                            if (validPalindrome(s.substring(i+1, j+1), maxDeleted-1)) {
                                return true;
                            }
                        }
                        if (s.charAt(i) == s.charAt(j-1)) {
                            if (validPalindrome(s.substring(i, j), maxDeleted-1)) {
                                return true;
                            }
                        }
                        return false;
                    } else {
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                i++;
                j--;
            }
        }
        return true;
    }


    public boolean validPalindrome2(String s) {
        if (isPalindrome(s)) {
            return  true;
        }

        for (int i=0; i<s.length(); i++) {
            StringBuilder sb = new StringBuilder();
            if (i>0) {
                sb.append(s.substring(0,i));
            }
            if (i < s.length() - 1) {
                sb.append(s.substring(i+1));
            }
            if (isPalindrome(sb.toString())) {
                return true;
            }
        }
        return false;
    }

    private boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.validPalindrome("aba"));
        System.out.println(vp.validPalindrome("abca"));
        System.out.println(vp.validPalindrome("abc"));
        System.out.println(vp.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
    }
}
