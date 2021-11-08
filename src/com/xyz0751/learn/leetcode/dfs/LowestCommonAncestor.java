package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 *
 * 难度 简单
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6 
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *  
 *
 * 说明:
 *
 * 所有节点的值都是唯一的。
 * p、q 为不同节点且均存在于给定的二叉搜索树中。
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val) {
            return p;
        }

        if (root.val == q.val) {
            return q;
        }

        if (q.val == p.val) {
            return q;
        }

        TreeNode lowerNode = q.val > p.val ? p : q;
        TreeNode higherNode = q.val < p.val ? p : q;
        if (lowerNode.val < root.val && higherNode.val > root.val) {
            return root;
        } else if (higherNode.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(6);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(0);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(5);
        node4.left = node5;
        node4.right = node6;

        node2.left = node3;
        node2.right = node4;

        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        node7.left = node8;
        node7.right = node9;

        node1.left = node2;
        node1.right = node7;

        LowestCommonAncestor algo = new LowestCommonAncestor();
        System.out.println(algo.lowestCommonAncestor(node1, node2, node4));
    }
}
