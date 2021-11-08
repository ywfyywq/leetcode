package com.xyz0751.learn.leetcode.dfs;

import com.xyz0751.learn.leetcode.common.Node;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * 难度 中等
 *
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 *  
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *  
 *
 * 示例：
 *
 *
 *
 * 输入：root = [1,2,3,4,5,6,7]
 * 输出：[1,#,2,3,#,4,5,6,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化的输出按层序遍历排列，同一层节点由 next 指针连接，'#' 标志着每一层的结束。
 *  
 *
 * 提示：
 *
 * 树中节点的数量少于 4096
 * -1000 <= node.val <= 1000
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Connect {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }

        root.next = null;

        Node mostLeftNode = root;
        Node currentNode = root;
        while(mostLeftNode != null) {
            while (currentNode != null) {
                if (currentNode.left != null) {
                    currentNode.left.next = currentNode.right;
                    if (currentNode.next != null) {
                        currentNode.right.next = currentNode.next.left;
                    }
                }
                currentNode = currentNode.next;
            }
            mostLeftNode = mostLeftNode.left;
            currentNode = mostLeftNode;
        }

        return root;
    }

    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }

        root.next = null;

        Node mostLeftNode = root;
        Node currentNode = root;
        while(mostLeftNode != null) {
            while (currentNode != null) {
                if (currentNode.left != null || currentNode.right != null) {
                    Node tempNode = null;
                    if (currentNode.left != null && currentNode.right != null) {
                        currentNode.left.next = currentNode.right;
                        tempNode = currentNode.right;
                    } else if (currentNode.right != null) {
                        tempNode = currentNode.right;
                    } else {
                        tempNode = currentNode.left;
                    }

                    do {
                        currentNode = currentNode.next;
                    } while (currentNode != null && currentNode.left == null && currentNode.right == null);
                    if (currentNode == null) {
                        break;
                    }
                    if (currentNode.left != null) {
                        tempNode.next = currentNode.left;
                    } else {
                        tempNode.next = currentNode.right;
                    }
                } else {
                    currentNode = currentNode.next;
                }
            }

            while(mostLeftNode != null && mostLeftNode.left == null && mostLeftNode.right == null) {
                mostLeftNode = mostLeftNode.next;
            }
            if (mostLeftNode == null) {
                break;
            }
            if (mostLeftNode.left != null) {
                mostLeftNode = mostLeftNode.left;
            } else if (mostLeftNode.right != null) {
                mostLeftNode = mostLeftNode.right;
            }
            currentNode = mostLeftNode;
        }

        return root;
    }

    public static void main(String[] args) {
        Node node1 = null;//new Node(4);
        Node node2 = null;//new Node(5);
        Node node3 = new Node(2);
        node3.left = node1;
        node3.right = node2;

        Node node4 = new Node(6);
        Node node5 = new Node(7);
        Node node6 = new Node(3);
        node6.left = node4;
        node6.right = node5;

        Node node7 = new Node(1);
        node7.left = node3;
        node7.right = node6;

        Connect algo = new Connect();
        System.out.println(algo.connect2(node7));
    }
}
