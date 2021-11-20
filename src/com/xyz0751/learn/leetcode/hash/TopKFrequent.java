package com.xyz0751.learn.leetcode.hash;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

import java.util.*;

/**
 * 347. 前 K 个高频元素
 *
 * 难度 中等
 *
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }
        Map<Integer, Integer> numsCount = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            numsCount.put(nums[i], numsCount.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Map.Entry<Integer, Integer> entry1 = (Map.Entry<Integer, Integer>) o1;
                Map.Entry<Integer, Integer> entry2 = (Map.Entry<Integer, Integer>) o2;
                return entry2.getValue() - entry1.getValue();
            }
        });
        Iterator<Map.Entry<Integer, Integer>> it = numsCount.entrySet().iterator();
        while (it.hasNext()) {
            pq.add(it.next());
        };

        int[] ans = new int[k];
        int index = 0;
        while (index < ans.length) {
            ans[index++] = pq.poll().getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        TopKFrequent algo = new TopKFrequent();
        ArrayUtils.print(algo.topKFrequent(new int[] {1,1,1,2,2,3}, 2));
        ArrayUtils.print(algo.topKFrequent(new int[] {1}, 1));
    }
}
