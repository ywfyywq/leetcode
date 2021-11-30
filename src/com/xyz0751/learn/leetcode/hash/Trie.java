package com.xyz0751.learn.leetcode.hash;

import java.util.HashSet;
import java.util.Set;
import java.util.Timer;

/**
 * 208. 实现 Trie (前缀树)
 * <p>
 * 难度 中等
 * <p>
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-trie-prefix-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Trie {
    Trie[] trie;
    boolean isLeaf;

    public Trie() {
        trie = new Trie[26];
        isLeaf = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.trie[idx] == null) {
                node.trie[idx] = new Trie();
            }
            node = node.trie[idx];
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        Trie node = searchPrefixNode(word);
        return node != null && node.isLeaf;
    }

    public boolean startsWith(String prefix) {
        return searchPrefixNode(prefix) != null;
    }

    private Trie searchPrefixNode(String prefix) {
        Trie node = this;
        for (int i=0; i<prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.trie[idx] == null) {
                return null;
            }
            node = node.trie[idx];
        }
        return node;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));;   // 返回 True
        System.out.println(trie.search("app"));     // 返回 False
        System.out.println(trie.startsWith("app")); // 返回 True
        trie.insert("app");
        System.out.println(trie.search("app"));     // 返回 True
    }
}
