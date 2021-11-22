package com.xyz0751.learn.leetcode.strings;

/**
 * 859. 亲密字符串
 *
 * 难度 简单
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 *
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 *
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 *
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 *
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * 示例 4：
 *
 * 输入：s = "aaaaaaabc", goal = "aaaaaaacb"
 * 输出：true
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() < 2 || goal.length() < 2) {
            return false;
        }

        if (s.length() != goal.length()) {
            return false;
        }

        int index1 = -1;
        int index2 = -1;
        int count = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (count == 0) {
                    index1 = i;
                } else {
                    index2 = i;
                }
                count++;
                if (count > 2) {
                    return false;
                }
            }
        }

        if (count == 0) {
            for (int i=0; i<s.length()-1; i++) {
                for (int j=i+1; j<s.length(); j++) {
                    if (s.charAt(i) == s.charAt(j) && i!=j) {
                        return true;
                    }
                }
            }
            return false;
        } else if (count == 1) {
            return false;
        } else {
            if (s.charAt(index1) == goal.charAt(index2) && s.charAt(index2) == goal.charAt(index1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BuddyStrings algo = new BuddyStrings();
        System.out.println(algo.buddyStrings("ab", "ba"));
        System.out.println(algo.buddyStrings("ab", "ab"));
        System.out.println(algo.buddyStrings("aa", "aa"));
        System.out.println(algo.buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }
}
