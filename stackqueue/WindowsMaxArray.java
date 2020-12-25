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
        if (arr == null || arr.length < n || n < 1) {
            throw new RuntimeException("窗口过小或者数组为空");
        }
        int[] res = new int[arr.length - n + 1];//存放每个窗口的最大值
        Deque<Integer> window = new LinkedList<>();//存放窗口内所有没有过期的值，整体是从大到小的，队列头部是最大值
        //（如果在同一窗口内，当前值的后面有比他还大或者和他相等的值，那么他就是过期值）
        for (int i = 0, j = 0; i < arr.length; i++) {
            while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) {
                window.pollLast();
            }
            window.addLast(i);
            if (window.peekFirst() == i - n) { //超过窗口长度的值也是过期值
                window.pollFirst();
            }
            if (i >= n - 1) {
                //将每一个最大值都存放
                res[j++] = arr[window.peekFirst()];
            }
        }
        return res;
    }
}
