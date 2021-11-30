package com.xyz0751.learn.leetcode.sliding;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 难度 中等
 *
 * 给定两个字符串   s   和 p，找到   s   中所有   p   的   异位词   的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 *
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 *
 *    
 *
 * 示例   1:
 *
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 *    示例 2:
 *
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 *    
 *
 * 提示:
 *
 * 1 <= s.length, p.length <= 3 * 104
 * s   和   p   仅包含小写字母
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {
    public List<Integer> findAnagrams2(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        for (int i=0; i<p.length(); i++) {
            Integer count = pMap.getOrDefault(p.charAt(i), 0);
            pMap.put(p.charAt(i), count+1);
        }

        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<=s.length()-p.length(); i++) {
            int j=i;
            Map<Character, Integer> temp = new HashMap<>();
            temp.putAll(pMap);
            for (; j-i<p.length(); j++) {
                if (!pMap.containsKey(s.charAt(j))) {
                    i = j;
                    break;
                } else {
                    Integer count = temp.get(s.charAt(j));
                    if (count == null) {
                        break;
                    }
                    if (count == 1) {
                        temp.remove(s.charAt(j));
                    } else {
                        temp.put(s.charAt(j), count-1);
                    }
                }
            }
            if (temp.size() == 0) {
                ans.add(i);
            }
        }
        return ans;
    }

    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return new ArrayList<Integer>();
        }

        List<Integer> ans = new ArrayList<Integer>();
        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < pLen; ++i) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < sLen - pLen; ++i) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + pLen) - 'a'];

            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        FindAnagrams algo = new FindAnagrams();
//        System.out.println(algo.findAnagrams("cbaebabacd", "abc"));
        System.out.println(algo.findAnagrams("ababababab", "aab"));
    }
}
