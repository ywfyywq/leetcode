package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 257. 二叉树的所有路径
 *
 * 难度 简单
 *
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *   
 * 示例 1：
 *
 *
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 *
 * 输入：root = [1]
 * 输出：["1"]
 *   
 *
 * 提示：
 *
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        if (root.left == null && root.right == null) {
            list.add(root.val+"");
            return list;
        }
        binaryTreePaths(root.left, list, root.val + "");
        binaryTreePaths(root.right, list, root.val + "");
        return list;
    }

    public List<String> binaryTreePaths(TreeNode root, List<String> list, String temp) {
        if (root == null) {
            return list;
        }

        if (root.left == null && root.right == null) {
            list.add(temp + "->" + root.val);
            return list;
        }

        if (root.left != null) {
            binaryTreePaths(root.left, list, temp + "->" + root.val);
        }

        if (root.right != null) {
            binaryTreePaths(root.right, list, temp + "->" + root.val);
        }

        return list;
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

        BinaryTreePaths algo = new BinaryTreePaths();
        System.out.println(algo.binaryTreePaths(node1));
    }
}
