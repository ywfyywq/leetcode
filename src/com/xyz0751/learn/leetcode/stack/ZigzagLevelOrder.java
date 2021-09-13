package com.xyz0751.learn.leetcode.stack;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ZigzagLevelOrder {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            List<Integer> row = Arrays.asList(root.val);
            result.add(row);
            return result;
        }
        Stack<TreeNode> currentRow = new Stack<>();
        currentRow.push(root);

        Stack<TreeNode> nextRow = new Stack<>();
        List<Integer> row = new ArrayList<>();
        while(!currentRow.isEmpty()) {
            TreeNode node = currentRow.pop();
            row.add(node.val);
            if (result.size() % 2 == 0) {
                if (node.left != null) {
                    nextRow.push(node.left);
                }
                if (node.right != null) {
                    nextRow.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextRow.push(node.right);
                }
                if (node.left != null) {
                    nextRow.push(node.left);
                }
            }

            if(currentRow.isEmpty()) {
                currentRow = nextRow;
                nextRow = new Stack<>();
                result.add(row);
                row = new ArrayList<>();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ZigzagLevelOrder order = new ZigzagLevelOrder();
        TreeNode root = new TreeNode();
        root.val = 3;
        TreeNode left = new TreeNode();
        left.val = 9;
        TreeNode right = new TreeNode();
        right.val = 20;
        root.left = left;
        root.right = right;
        TreeNode left1 = new TreeNode();
        left1.val = 15;
        TreeNode right1 = new TreeNode();
        right1.val = 7;
        right.left = left1;
        right.right = right1;

        System.out.println(order.zigzagLevelOrder(root));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}