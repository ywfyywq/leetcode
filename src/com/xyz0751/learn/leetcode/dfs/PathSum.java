package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 113. 路径总和 II
 *
 * 难度 中等
 *
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 *   
 *
 * 示例 1：
 *
 *
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 * 示例 2：
 *
 *
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1,2], targetSum = 0
 * 输出：[]
 *   
 *
 * 提示：
 *
 * 树中节点总数在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        pathSum(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        if (root == null) {
            return result;
        }

        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                List<Integer> list = new ArrayList<>(temp.size());
                list.addAll(temp);
                result.add(list);
            }
        }

        if (root.left != null) {
            List<Integer> list = new ArrayList<>(temp.size());
            list.addAll(temp);
            pathSum(root.left, targetSum-root.val, result, list);
        }

        if (root.right != null) {
            List<Integer> list = new ArrayList<>(temp.size());
            list.addAll(temp);
            pathSum(root.right, targetSum-root.val, result, list);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);

        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(8);

        TreeNode node4 = new TreeNode(11);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(2);
        node4.left = node5;
        node4.right = node6;

        node2.left = node4;

        TreeNode node7 = new TreeNode(13);
        TreeNode node8 = new TreeNode(4);
        node3.left = node7;
        node3.right = node8;

        TreeNode node10 = new TreeNode(5);
        TreeNode node11 = new TreeNode(1);
        node8.left = node10;
        node8.right = node11;

        node1.left = node2;
        node1.right = node3;

        PathSum algo = new PathSum();
        System.out.println(algo.pathSum(node1, 22));
    }
}
