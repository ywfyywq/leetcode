package com.xyz0751.learn.leetcode.stack;

import com.xyz0751.learn.leetcode.utils.ArrayUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 难度 中等
 *
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 示例 1:
 *
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 *
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 *
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 *  
 *
 * 提示：
 *
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 *
 * @author 力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> monoStack = new Stack<>();

        int[] waitDays = new int[temperatures.length];
        for (int i=0; i < temperatures.length; i++) {
            if (!monoStack.isEmpty() ) {
                while (!monoStack.isEmpty() && temperatures[i] > temperatures[monoStack.peek()]) {
                    int index = monoStack.pop();
                    waitDays[index] = i-index;
                }
            }
            monoStack.push(i);
        }

        return waitDays;
    }

    public static void main(String[] args) {
        DailyTemperatures algo = new DailyTemperatures();
        ArrayUtils.print(algo.dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}));
        ArrayUtils.print(algo.dailyTemperatures(new int[] {30,40,50,60}));
        ArrayUtils.print(algo.dailyTemperatures(new int[] {30,60,90}));
    }
}
