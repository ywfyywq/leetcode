package com.xyz0751.learn.leetcode.dp;

public class NumArray2 {
    private int[] nums = null;
    private int[] tree = null;

    public NumArray2(int[] nums) {
        this.nums = nums;
        this.tree = new int[4 * nums.length];
        buildSegementTree(0, 0, nums.length-1);
    }

    private void buildSegementTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = nums[l];
            return;
        }

        int leftTreeIndex = leftChildIndex(treeIndex);
        int rightTreeIndex = rightChildIndex(treeIndex);
        int mid = l + (r-l)/2;
        buildSegementTree(leftTreeIndex, l, mid);
        buildSegementTree(rightTreeIndex, mid+1, r);
        tree[treeIndex] = tree[leftTreeIndex] + tree[rightTreeIndex];
    }

    private int query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int leftTreeIndex = leftChildIndex(treeIndex);
        int rightTreeIndex = rightChildIndex(treeIndex);
        int mid = l + (r-l)/2;
        if(queryL >= mid+1) {
            return query(rightTreeIndex, mid+1, r, queryL, queryR);
        } else if (queryR <= mid){
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        int leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        int rightResult = query(rightTreeIndex, mid+1, r, mid+1, queryR);
        return leftResult + rightResult;
    }

    private int leftChildIndex(int index) {
        return 2*index+1;
    }

    private int rightChildIndex(int index) {
        return 2*index+2;
    }

    public int sumRange(int left, int right) {
        return query(0, 0,nums.length-1, left, right);
    }

    public static void main(String[] args) {
        NumArray2 numArray = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }
}
