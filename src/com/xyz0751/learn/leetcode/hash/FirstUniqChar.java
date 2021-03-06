package com.xyz0751.learn.leetcode.hash;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 难度 简单
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * 
 *
 * 示例：
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 * 
 *
 * 提示：你可以假定该字符串只包含小写字母。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/first-unique-character-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] counts = new int[26];
        for (int i=0; i<s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        for (int i=0; i<s.length(); i++) {
            if (counts[s.charAt(i)-'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqChar algo = new FirstUniqChar();
        System.out.println(algo.firstUniqChar("leetcode"));
        System.out.println(algo.firstUniqChar("loveleetcode"));
    }
}
