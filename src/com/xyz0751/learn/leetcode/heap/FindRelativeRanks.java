package com.xyz0751.learn.leetcode.heap;

import java.util.*;

/**
 * 506. 相对名次
 * <p>
 * 难度 简单
 * 给出    N 名运动员的成绩，找出他们的相对名次并授予前三名对应的奖牌。前三名运动员将会被分别授予 “金牌”，“银牌” 和“ 铜牌”（"Gold Medal", "Silver Medal", "Bronze Medal"）。
 * <p>
 * (注：分数越高的选手，排名越靠前。)
 * <p>
 * 示例 1:
 * <p>
 * 输入: [5, 4, 3, 2, 1]
 * 输出: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * 解释: 前三名运动员的成绩为前三高的，因此将会分别被授予 “金牌”，“银牌”和“铜牌” ("Gold Medal", "Silver Medal" and "Bronze Medal").
 * 余下的两名运动员，我们只需要通过他们的成绩计算将其相对名次即可。
 * 提示:
 * <p>
 * N 是一个正整数并且不会超过    10000。
 * 所有运动员的成绩都不相同。
 * <p>
 * @author  力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindRelativeRanks {
    public String[] findRelativeRanks2(int[] score) {
        int[] rankScore = Arrays.copyOf(score, score.length);
        Arrays.sort(rankScore);
        Map<Integer, Integer> rank = new HashMap<>();
        for (int i=0; i<rankScore.length; i++) {
            rank.put(rankScore[i], rankScore.length-i);
        }
        String[] rankString = new String[score.length];
        for (int i=0; i<score.length; i++) {
            Integer rankNum = rank.get(score[i]);
            if (rankNum == 1) {
                rankString[i] = "Gold Medal";
            } else if (rankNum == 2) {
                rankString[i] = "Silver Medal";
            } else if (rankNum == 3) {
                rankString[i] = "Bronze Medal";
            } else {
                rankString[i] = rankNum + "";
            }
        }

        return rankString;
    }

    public String[] findRelativeRanks3(int[] score) {
        PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o2[0] - o1[0];
            }
        });
        for (int i=0; i<score.length; i++) {
            queue.add(new Integer[]{score[i], i});
        }

        String[] ranks = new String[score.length];
        int rank = 1;
        while(!queue.isEmpty()) {
            Integer index = queue.poll()[1];
            if (rank == 1) {
                ranks[index] = "Gold Medal";
            } else if (rank == 2) {
                ranks[index] = "Silver Medal";
            } else if (rank == 3) {
                ranks[index] = "Bronze Medal";
            } else {
                ranks[index] = rank + "";
            }
            rank++;
        }
        return ranks;
    }

    public String[] findRelativeRanks(int[] score) {
        int maxScore = 0;
        for (int i=0; i<score.length; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }
        int[] allScore = new int[maxScore+1];
        for (int i=0; i<score.length; i++) {
            allScore[score[i]] = i+1;
        }

        int rank = 1;
        String[] ranks = new String[score.length];
        for (int i = maxScore; i>=0; i--) {
            if (allScore[i] != 0) {
                if (rank == 1) {
                    ranks[allScore[i]-1] = "Gold Medal";
                } else if (rank == 2) {
                    ranks[allScore[i]-1] = "Silver Medal";
                } else if (rank == 3) {
                    ranks[allScore[i]-1] = "Bronze Medal";
                } else {
                    ranks[allScore[i]-1] = rank + "";
                }
                rank++;
            }
        }

        return ranks;
    }

        public static void main(String[] args) {
        FindRelativeRanks algo = new FindRelativeRanks();
//        System.out.println(algo.findRelativeRanks(new int[] {5,4,6,3,2,1}));
        System.out.println(algo.findRelativeRanks(new int[] {100,111,111111}));
    }
}
