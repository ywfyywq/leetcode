package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * 难度 简单
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 *
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.right = leftNode;
        root.left = rightNode;

        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);

        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        node2.left = node3;
        node2.right = node4;

        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(9);
        node5.left = node6;
        node5.right = node7;

        node1.left = node2;
        node1.right = node5;

        InvertTree algo = new InvertTree();
        System.out.println(algo.invertTree(node1));
    }
}
