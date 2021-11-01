package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.TreeNode;

/**
 * 100. 相同的树
 *
 * 难度 简单
 *
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 *  
 *
 * 示例 1：
 *
 *
 * 输入：p = [1,2,3], q = [1,2,3]
 * 输出：true
 * 示例 2：
 *
 *
 * 输入：p = [1,2], q = [1,null,2]
 * 输出：false
 * 示例 3：
 *
 *
 * 输入：p = [1,2,1], q = [1,1,2]
 * 输出：false
 *  
 *
 * 提示：
 *
 * 两棵树上的节点数目都在范围 [0, 100] 内
 * -104 <= Node.val <= 104
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/same-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        }

        if (p == null && q != null) {
            return false;
        }

        if (p != null && q == null) {
            return false;
        }

        if (p.val != q.val) {
            return false;
        }

        if (p.left == null && q.left != null) {
            return false;
        }

        if (p.left != null && q.left == null) {
            return false;
        }

        if (!isSameTree(p.left, q.left)) {
            return false;
        }

        if (p.right == null && q.right != null) {
            return false;
        }

        if (p.right != null && q.right == null) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode one1 = new TreeNode(1);
        TreeNode two1 = new TreeNode(2);
        TreeNode three1 = new TreeNode(3);
        one1.left = two1;
        one1.right = three1;

        TreeNode one2 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        TreeNode three2 = new TreeNode(4);
        one2.left = two2;
        one2.right = three2;
        IsSameTree algo = new IsSameTree();
        System.out.println(algo.isSameTree(one1, one1));;
    }
}
