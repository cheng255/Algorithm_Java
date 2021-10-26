package com.cheng.stackqueue.下一个更大元素;

/**
 * 556. 下一个更大元素 III
 * 给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。
 *
 * 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：21
 * 示例 2：
 *
 * 输入：n = 21
 * 输出：-1
 *
 * 思路：就是找到比这个数字大的第一个数字
 * @author nuonuo
 * @create 2021-10-26 22:03
 */
public class T03 {
    public int nextGreaterElement(int n) {
        // 124652
        int[] nums = new int[10];
        int i = 0;
        while (n > 0) {
            nums[i++] = n % 10;
            n /= 10;
        }
        int len = i;
        i = 1;
        while (i < len && nums[i] >= nums[i-1]) {
            ++i;
        }
        if (i >= len) {
            //说明没有
            return -1;
        }
        //说明有,就找到最低位置的大于i位置元素的元素j
        int j = i - 1;
        while (j >= 0 && nums[j] > nums[i]) {
            j--;
        }
        j++;
        //然后交换，然后将低位全部反转
        swap(nums, i, j);
        // System.out.println(i + ", " + j);
        i--;    j = 0;
        while (i > j) {
            swap(nums, i--, j++);
        }
        //最后重新组合
        long newN = 0;
        i = len - 1;
        while (i >= 0) {
            newN = newN * 10 + nums[i--];
        }
        if (newN > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)newN;
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
