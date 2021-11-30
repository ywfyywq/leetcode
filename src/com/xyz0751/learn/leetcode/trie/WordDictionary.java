package com.xyz0751.learn.leetcode.trie;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 *
 * 难度 中等
 *
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 *
 * 实现词典类 WordDictionary ：
 *
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与  word 匹配，则返回 true ；否则，返回   false 。word 中可能包含一些 '.' ，每个  . 都可以表示任何一个字母。
 *   
 *
 * 示例：
 *
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 *
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *   
 *
 * 提示：
 *
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 50000 次 addWord 和 search
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WordDictionary {
    WordDictionary[] trie;
    boolean isLeaf;

    public WordDictionary() {
        trie = new WordDictionary[26];
        isLeaf = false;
    }

    public void addWord(String word) {
        WordDictionary node = this;
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.trie[idx] == null) {
                node.trie[idx] = new WordDictionary();
            }
            node = node.trie[idx];
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        WordDictionary node = search(this, word);
        return node != null && node.isLeaf;
    }

    public WordDictionary search(WordDictionary node, String word) {
        WordDictionary tmpNode = node;
        if (tmpNode == null) {
            return null;
        }
        for (int i=0; i<word.length(); i++) {
            if (word.charAt(i) == '.') {
                for (int j=0; j<tmpNode.trie.length; j++) {
                    if (tmpNode.trie[j] != null) {
                        if (i != word.length()-1) {
                            WordDictionary child = search(tmpNode.trie[j], word.substring(i + 1));
                            if (child != null && child.isLeaf) {
                                return child;
                            }
                        } else if (tmpNode.trie[j].isLeaf){
                            return tmpNode.trie[j];
                        }
                    }
                }
                return null;
            } else {
                int idx = word.charAt(i) - 'a';
                if (tmpNode.trie[idx] == null) {
                    return null;
                }
                tmpNode = tmpNode.trie[idx];
            }
        }
        return tmpNode;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.search("pad")); // return False
//        System.out.println(wordDictionary.search("bad")); // return True
//        System.out.println(wordDictionary.search(".ad")); // return True
//        System.out.println(wordDictionary.search("b.")); // return True
        System.out.println(wordDictionary.search("a.")); // return True
    }
}
