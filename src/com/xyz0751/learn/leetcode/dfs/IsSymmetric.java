package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 101. 对称二叉树
 *
 * 难度 简单
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    public static void main(String[] args) {
        IsSymmetric algo = new IsSymmetric();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode (2);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode (2);
        TreeNode node5 = null;
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node4;
//        node3.right = node4;

        System.out.println(algo.isSymmetric(node1));
    }
}
