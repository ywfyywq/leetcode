package com.xyz0751.learn.leetcode.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            int j=0;
            while (nums1[i] != nums2[j++]);
            if (j >= nums2.length) {
                result[i] = -1;
            } else {
                for (; j<nums2.length; j++) {
                    if (nums1[i] < nums2[j]) {
                        result[i] = nums2[j];
                        break;
                    }
                }
                if (j >= nums2.length) {
                    result[i] = -1;
                }
            }
        }
        return result;
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nge = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<nums2.length; i++) {
            if (stack.isEmpty() || stack.peek() >= nums2[i]) {
                stack.push(nums2[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                    nge.put(stack.pop(), nums2[i]);
                }
                stack.push(nums2[i]);
            }
        }

        while (!stack.isEmpty()) {
            nge.put(stack.pop(), -1);
        }
        int [] result = new int[nums1.length];
        for (int i=0; i<result.length; i++) {
            result[i] = nge.get(nums1[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        NextGreaterElement nge = new NextGreaterElement();
        nge.nextGreaterElement(new int[]{2,1,3}, new int[] {2,3,5,1,0,7});
    }
}
