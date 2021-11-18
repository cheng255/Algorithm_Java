package day04;

import java.util.Deque;
import java.util.LinkedList;

/**
 请根据每日 气温 列表 temperatures ，重新生成一个列表，要求其对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 示例 1:

 输入: temperatures = [73,74,75,71,69,72,76,73]
 输出: [1,1,4,2,1,1,0,0]

 思路：单调栈  没啥说的
 */
public class 每日温度038 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                res[stack.peek()] = i - stack.poll();
            }
            stack.push(i);
        }
        //单调栈里剩下的递减序列就都是0
        return res;
    }
}
