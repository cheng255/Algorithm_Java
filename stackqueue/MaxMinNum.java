package com.cheng.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量     牛
 *
 *
 * 双指针+栈    注意: 将双指针分成两层循环，往往能更加方便的解决问题  while(l < arr.length && r < arr.length) {
 *
 *                                                                  }                       ->
 *                                                                while (l < arr.length) {
 *                                                                    while (r < arr.length) {
 *
 *                                                                    }
 *                                                                }
 * 10道题总结：重点1：用双端队列（窗口内最大值）可以解决动态找最值的需求  比如该题中需要动态得到子数组中的最大最小值，则需要构建maxQ minQ
 *             重点2：多用中心扩展的思路，比如 ① 生成大根堆数MaxTree   就是当前位置想两边扩展，寻找父结点
 *                                          ② 求最大子矩阵  某一层为底时 就是将每一列的高度往两边扩展，从而找到最大矩阵
 *                     方法是使用单调栈，栈中存放一个递增（递减）序列，旨在分别找到左右第一个大于（小于）当前值的数
 *             难点1：用栈模拟递归    栈版本的汉诺塔问题，还没有想清楚。。。
 * @author nuonuo
 * @create 2020-12-24 16:25
 */
public class MaxMinNum {
    public static void main(String[] args) {
        System.out.println(getNum(new int[]{3, 1, 2, 4, 5, 6}, 3));
    }

    private static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        //1.创建一个最小数队列 和最大数队列
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        //2.遍历数组，并填充最大数栈和最小数栈
        int left = 0, right = 0, res = 0;
        while (left < arr.length) {
            while (right < arr.length) {
                while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[right]) {
                    minDeque.pollLast();
                }
                while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[right]) {
                    maxDeque.pollLast();
                }
                minDeque.addLast(right);
                maxDeque.addLast(right);
                //3.遍历过程中每次子数组变化后都判断与num的关系
                int diff = arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()];
                if (diff > num) {
                    //4.如果最大值和最小值的差值大于num，则说明【left, right - 1】该范围内的所有子数组都满足差值小于等于num
                    break;
                }
                //5.如果差值小于等于num，则继续往前扩展
                right++;
            }
            //6.差值大于num跳到这里，此时需要移动left  使得再次满足小于等于num
            //并且也说明以left开头的子数组最多可以扩展到right-1位置
            if (minDeque.peekFirst() == left) {
                minDeque.pollFirst();
            }
            if (maxDeque.peekFirst() == left) {
                maxDeque.pollFirst();
            }
            res += right - left;
            left++;
        }
        return res;
    }
}
