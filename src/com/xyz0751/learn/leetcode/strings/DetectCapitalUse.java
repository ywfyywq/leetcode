package com.xyz0751.learn.leetcode.strings;

/**
 * 520. 检测大写字母
 *
 * 难度 简单
 *
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 *
 * 全部字母都是大写，比如 "USA" 。
 * 单词中所有字母都不是大写，比如 "leetcode" 。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
 * 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：word = "USA"
 * 输出：true
 * 示例 2：
 *
 * 输入：word = "FlaG"
 * 输出：false
 *  
 *
 * 提示：
 *
 * 1 <= word.length <= 100
 * word 由小写和大写英文字母组成
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/detect-capital
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DetectCapitalUse {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1) {
            return true;
        }

        if (word.toUpperCase().equals(word)) {
            return true;
        }
        String subString = word.substring(1);
        if (subString.toLowerCase().equals(subString)) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCapitalUse algo = new DetectCapitalUse();
        System.out.println(algo.detectCapitalUse("USA"));
        System.out.println(algo.detectCapitalUse("FlaG"));
        System.out.println(algo.detectCapitalUse("leetcode"));
        System.out.println(algo.detectCapitalUse("Google"));
    }

}
