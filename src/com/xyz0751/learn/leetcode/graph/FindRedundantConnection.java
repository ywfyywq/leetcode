package com.xyz0751.learn.leetcode.graph;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

import java.util.*;

/**
 * 684. 冗余连接
 *
 * 难度 中等
 *
 * 树可以看成是一个连通且 无环 的 无向 图。
 *
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 *
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的边。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 示例 2：
 *
 *
 *
 * 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 *  
 *
 * 提示:
 *
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的 
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/redundant-connection
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for (int i=0; i<parent.length; i++) {
            parent[i] = i;
        }

        for (int i=0; i<edges.length; i++) {
            if (find(parent, edges[i][0]) != find(parent, edges[i][1])) {
                union(parent, edges[i][0], edges[i][1]);
            } else {
                return edges[i];
            }
        }
        return new int[0];
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent,index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
       if (index != parent[index]) {
           parent[index] = find(parent, parent[index]);
       }

       return parent[index];
    }

    public static void main(String[] args) {
        FindRedundantConnection algo = new FindRedundantConnection();
        ArrayUtils.print(algo.findRedundantConnection(new int[][]{{1,2}, {1,3}, {2,3}}));
    }
}
