package com.xyz0751.learn.leetcode.hash;

/**
 * 383. 赎金信
 *
 * 难度 简单
 *
 * 为了不在赎金信中暴露字迹，从杂志上搜索各个需要的字母，组成单词来表达意思。
 *
 * 给你一个赎金信 (ransomNote) 字符串和一个杂志(magazine)字符串，判断 ransomNote 能不能由 magazines 里面的字符构成。
 *
 * 如果可以构成，返回 true ；否则返回 false 。
 *
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 *
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 *
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 
 *
 * 提示：
 *
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ransom-note
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] chars = new int[26];
        for (int i=0; i<magazine.length(); i++) {
            chars[magazine.charAt(i)-'a']++;
        }

        for (int i=0; i<ransomNote.length(); i++) {
            if (--chars[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        CanConstruct algo = new CanConstruct();
        System.out.println(algo.canConstruct("a", "b"));
        System.out.println(algo.canConstruct("aa", "ab"));
        System.out.println(algo.canConstruct("aa", "aab"));

    }
}
