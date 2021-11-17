package com.xyz0751.learn.leetcode.bits;

import java.util.BitSet;

/**
 * 318. 最大单词长度乘积
 *
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16 
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4 
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0 
 * 解释: 不存在这样的两个单词。
 *  
 *
 * 提示：
 *
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public int maxProduct(String[] words) {
        long[] bits = new long[words.length];

        for (int i=0; i<bits.length; i++) {
            for (int j=0; j<words[i].length(); j++) {
                bits[i] = bits[i] | (1 << (words[i].charAt(j)-'a'));
            }
        }

        int maxLen = 0;
        for (int i=0; i<words.length-1; i++) {
            for (int j=1; j<words.length; j++) {
                if ((bits[i] & bits[j]) == 0) {
                    maxLen = Math.max(maxLen, words[i].length() * words[j].length());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaxProduct algo = new MaxProduct();
        System.out.println(algo.maxProduct( new String[] {"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(algo.maxProduct( new String[] {"a","ab","abc","d","cd","bcd","abcd"}));
        System.out.println(algo.maxProduct( new String[] {"a","aa","aaa","aaaa"}));
    }
}
