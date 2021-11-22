package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 104. 二叉树的最大深度
 *
 * 难度 简单
 *
 * 给定一个 N 叉树，找到其最大深度。
 *
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 *
 * N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。
 *
 *    
 *
 * 示例 1：
 *
 *
 *
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：3
 * 示例 2：
 *
 *
 *
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：5
 *    
 *
 * 提示：
 *
 * 树的深度不会超过   1000 。
 * 树的节点数目位于 [0,   104] 之间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class NTreeMaxDepth {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxChildDepth = 0;
        List<Node> children = root.children;
        if (children != null) {
            for (Node child : children) {
                int childDepth = maxDepth(child);
                maxChildDepth = Math.max(maxChildDepth, childDepth);
            }
        }
        return maxChildDepth + 1;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);

        Node node2 = new Node(3);
        Node node3 = new Node(2);
        Node node4 = new Node(4);
        List<Node> list1 = new ArrayList<>();
        list1.add(node2);
        list1.add(node3);
        list1.add(node4);

        node1.children = list1;

        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list2 = new ArrayList<>();
        list2.add(node5);
        list2.add(node6);
        node2.children = list2;

        Node node7 = new Node(7);
        List<Node> list3 = new ArrayList<>();
        list3.add(node7);
        node4.children = list3;

        Node node8 = new Node(8);
        List<Node> list4 = new ArrayList<>();
        list4.add(node8);
        node7.children = list4;

        Node node9 = new Node(9);
        List<Node> list5 = new ArrayList<>();
        list5.add(node9);
        node8.children = list5;


        NTreeMaxDepth algo = new NTreeMaxDepth();
        System.out.println(algo.maxDepth(node1));
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
