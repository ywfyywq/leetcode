package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. 二叉树的中序遍历
 *
 * 难度 简单
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 * @author leetcode
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal(list, root);
        return list;
    }

    private void inorderTraversal(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            inorderTraversal(list, root.left);
        }
        list.add(root.val);
        if (root.right != null) {
            inorderTraversal(list, root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;
        InorderTraversal algo = new InorderTraversal();
        algo.inorderTraversal(one);
    }
}
