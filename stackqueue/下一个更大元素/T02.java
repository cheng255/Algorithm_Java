package com.cheng.stackqueue.下一个更大元素;

import java.util.Arrays;
import java.util.Stack;

/**
 * 503. 下一个更大元素 II
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 *
 * 示例 1:
 *
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * @author nuonuo
 * @create 2021-10-26 22:03
 *
 * 思路：单调栈  不同的是要循环两遍
 */
public class T02 {
    public int[] nextGreaterElements(int[] nums) {

        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        int i = 0;
        while (flag || i < nums.length) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                res[stack.pop()] = nums[i];
            }
            stack.push(i);
            i++;
            if (i == nums.length && flag) {
                i = 0;
                flag = false;
            }
        }

        return res;
    }
}
