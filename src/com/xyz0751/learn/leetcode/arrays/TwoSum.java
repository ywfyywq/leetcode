package com.xyz0751.learn.leetcode.arrays;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

import java.util.*;

public class TwoSum {
    public  static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {0, 1};
        }

        for(int i=0; i< nums.length; i++) {
            for (int j=0; j< nums.length; j++) {
                if (i != j) {
                    if(target == nums[i] + nums[j]) {
                        return new int[] {i, j};
                    }
                }
            }
        }
        return new int[] {-1, -1};
    }

    public  static int[] twoSum2(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {0, 1};
        }

        List<Integer> originNums = new ArrayList<>();
        for (int i=0; i< nums.length; i++) {
            originNums.add(nums[i]);
        }

        for (int i=0; i< nums.length; i++) {
            if (originNums.contains(target - nums[i])) {
                int index = originNums.indexOf(target-nums[i]);
                if (index != i) {
                    return new int[]{index, i};
                }
            }
        }

        return new int[] {-1, -1};
    }

    public  static int[] twoSum3(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[] {0, 1};
        }

        Map<Integer, Integer> originNums = new HashMap<>();

        for (int i=0; i< nums.length; i++) {
            if (originNums.containsKey(target - nums[i])) {
                return new int[]{originNums.get(target - nums[i]), i};
            }
            originNums.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        ArrayUtils.print(twoSum2(new int[]{2,7,11,15}, 9));
        ArrayUtils.print(twoSum2(new int[]{3,2,4}, 6));
        ArrayUtils.print(twoSum2(new int[]{3,3}, 6));
    }
}
