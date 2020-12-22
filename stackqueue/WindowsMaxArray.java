package com.cheng.stackqueue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 程序员代码面试指南 生成窗口最大值数组
 *
 * @author nuonuo
 * @create 2020-12-22 12:54
 */
public class WindowsMaxArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(windowsMaxArray(new int[]{4,3,5,4,3,3,6,7}, 3)));
    }

    /**
     * @param arr
     * @param n   窗口大小
     * @return 窗口内最大值数组
     * <p>
     * 核心思路是创建一个队列，先进入的且小于后面的元素就无价值，就出队列
     * 步骤：当前元素入队列时判断：1.如果队列为空，直接入队列
     * 2.如果比队列尾部的元素大或等于，那么队尾元素就没用了。出队列
     * 3.如果比队列尾部元素小，那么直接入队列
     */
    private static int[] windowsMaxArray(int[] arr, int n) {
        if (arr == null || arr.length < n) {
            throw new RuntimeException("窗口大小不符合要求");
        }
        int[] maxArray = new int[arr.length - n + 1];
        Deque<Integer> window = new LinkedList<>(); //窗口队列的意义是存储当前的尚未过期的子窗口最大值的下标
        //初始化窗口 和 第一个窗口的最大值
        for (int i = 0, j = 0; i < arr.length; i++) {
            while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) {
                //2
                window.pollLast();
            }
            window.addLast(i);
            if (window.peekFirst() == i - n) {
                window.pollFirst();
            }
            if (i >= n - 1) {
                //到这窗口内就是从大到小的序列 ,第一个最大值就是window.peekFirst;
                maxArray[j++] = arr[window.peekFirst()];
            }
        }
        return maxArray;
    }
}
