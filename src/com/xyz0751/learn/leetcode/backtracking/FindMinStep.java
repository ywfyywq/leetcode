package com.xyz0751.learn.leetcode.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 488. 祖玛游戏
 * <p>
 * 难度 困难
 * <p>
 * 你正在参与祖玛游戏的一个变种。
 * <p>
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * <p>
 * 你的目标是 清空 桌面上所有的球。每一回合：
 * <p>
 * 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。
 * 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。
 * 如果桌面上所有球都被移除，则认为你赢得本场游戏。
 * 重复这个过程，直到你赢了游戏或者手中没有更多的球。
 * 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = "WRRBBW", hand = "RB"
 * 输出：-1
 * 解释：无法移除桌面上的所有球。可以得到的最好局面是：
 * - 插入一个 'R' ，使桌面变为 WRRRBBW 。WRRRBBW -> WBBW
 * - 插入一个 'B' ，使桌面变为 WBBBW 。WBBBW -> WW
 * 桌面上还剩着球，没有其他球可以插入。
 * 示例 2：
 * <p>
 * 输入：board = "WWRRBBWW", hand = "WRBRW"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'R' ，使桌面变为 WWRRRBBWW 。WWRRRBBWW -> WWBBWW
 * - 插入一个 'B' ，使桌面变为 WWBBBWW 。WWBBBWW -> WWWW -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 * 示例 3：
 * <p>
 * 输入：board = "G", hand = "GGGGG"
 * 输出：2
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'G' ，使桌面变为 GG 。
 * - 插入一个 'G' ，使桌面变为 GGG 。GGG -> empty
 * 只需从手中出 2 个球就可以清空桌面。
 * 示例 4：
 * <p>
 * 输入：board = "RBYYBBRRB", hand = "YRBGB"
 * 输出：3
 * 解释：要想清空桌面上的球，可以按下述步骤：
 * - 插入一个 'Y' ，使桌面变为 RBYYYBBRRB 。RBYYYBBRRB -> RBBBRRB -> RRRB -> B
 * - 插入一个 'B' ，使桌面变为 BB 。
 * - 插入一个 'B' ，使桌面变为 BBB 。BBB -> empty
 * 只需从手中出 3 个球就可以清空桌面。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 16
 * 1 <= hand.length <= 5
 * board 和 hand 由字符 'R'、'Y'、'B'、'G' 和 'W' 组成
 * 桌面上一开始的球中，不会有三个及三个以上颜色相同且连着的球
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuma-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMinStep {

//    public int findMinStep(String board, String hand) {
//        Map<Character, Integer> counter = new HashMap<>();
//
//        for (int i=0; i<hand.length(); i++) {
//            Character c = hand.charAt(i);
//            if (counter.containsKey(c)) {
//                counter.put(c, counter.get(c)+1);
//            } else {
//                counter.put(c, 1);
//            }
//        }
//        int ans = backtrack(board, counter);
//        return ans > 5 ? -1 : ans;
//    }
//
//    public int backtrack(String board, Map<Character, Integer> counter) {
//        if (board == null || "".equals(board)) {
//            return 0;
//        }
//
//        int i = 0, ans = 6;
//
//        while (i < board.length()) {
//            // 计算连续颜色的球
//            int j = i + 1;
//            while (j < board.length() && board.charAt(i) == board.charAt(j)) {
//                j += 1;
//            }
//            // 不可能超过3个，超过3个就自动消掉了
//            int balls = 3 - (j - i);
//            int ballsInHand =  counter.getOrDefault(board.charAt(i), 0);
//            if (ballsInHand >= balls) {
//                counter.put(board.charAt(i), ballsInHand-balls);
//                if (j<board.length()) {
//                    ans = Math.min(ans, balls + backtrack(board.substring(0, i) + board.substring(j), counter));
//                } else {
//                    ans = Math.min(ans, balls + backtrack(board.substring(0, i), counter));
//                }
//                counter.put(board.charAt(i),ballsInHand);
//            }
//            i=j;
//        }
//        return ans;
//    }

    private int result = Integer.MAX_VALUE;

    private int[] map = new int[26];

    private char[] colors = {'R', 'Y', 'B', 'G', 'W'};

    public int findMinStep(String board, String hand) {
        for (int i = 0; i < hand.length(); i++) {
            map[hand.charAt(i) - 'A']++;
        }
        dfs(new StringBuilder(board), 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private void dfs(StringBuilder board, int step) {
        if (step >= result) {
            return;
        }
        if (board.length() == 0) {
            result = Math.min(step, result);
            return;
        }
        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            int j = i;
            while (j + 1 < board.length() && board.charAt(j + 1) == c) {
                j++;
            }
            if (j == i && map[c - 'A'] >= 2) {  //只有单个球
                StringBuilder tmp = new StringBuilder(board);
                tmp.insert(i, c + "" + c);
                map[c - 'A'] -= 2;
                dfs(eliminate(tmp), step + 2);
                map[c - 'A'] += 2;
            } else if (j == i + 1) {    //存在两个颜色相同且相邻的球
                if (map[c - 'A'] >= 1) {
                    StringBuilder tmp = new StringBuilder(board);
                    tmp.insert(i, c);
                    map[c - 'A']--;
                    dfs(eliminate(tmp), step + 1);
                    map[c - 'A']++;
                }
                for (char color : colors) {
                    if (color == c) {
                        continue;
                    }
                    if (map[color - 'A'] >= 1) {
                        StringBuilder tmp = new StringBuilder(board);
                        tmp.insert(i + 1, color);   //尝试往这两个颜色相同且相邻的球中间插入一个颜色不同的球
                        map[color - 'A']--;
                        dfs(eliminate(tmp), step + 1);
                        map[color - 'A']++;
                    }
                }
            }
        }
    }

    private StringBuilder eliminate(StringBuilder sb) {
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < sb.length(); i++) {
                int j = i + 1;
                while (j < sb.length() && sb.charAt(j) == sb.charAt(i)) {
                    j++;
                }
                if (j - i >= 3) {
                    sb.delete(i, j);
                    flag = true;
                }
            }
        }
        return sb;
    }

    public static void main(String[] args) {
        FindMinStep algo = new FindMinStep();
//        System.out.println(algo.findMinStep("WRRBBW", "RB"));
        System.out.println(algo.findMinStep("WWRRBBWW", "WRBRW"));
//        System.out.println(algo.findMinStep("G", "GGGGG"));
//        System.out.println(algo.findMinStep("RBYYBBRRB", "YRBGB"));
    }
}
