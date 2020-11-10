package com.cheng.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 03. 数组中重复的数字   （拓展）
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，
 * 但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中重复的数字。
 *
 * @author nuonuo
 * @create 2020-11-10 15:34
 */
public class FindRepeatedNumber {
    public static void main(String[] args) {
        int[] ints = new int[10];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (int)(Math.random() * 10);
        }
        System.out.println(Arrays.toString(ints));
        System.out.println(findRepeatedNumber(ints));
    }

    // 如果没有重复数字，那么正常排序后，数字i应该在下标为i的位置，所以思路是重头扫描数组，
    // 遇到下标为i的数字如果不是i的话，（假设为m),
//那么我们就拿与下标m的数字交换。在交换过程中，如果有重复的数字就加入结果
    private static List<Integer> findRepeatedNumber(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                continue;
            }
            int m = arr[i];
            if (arr[i] == arr[m]) {
                if (!list.contains(arr[i])) {
                    list.add(arr[i]);
                }
                continue;
            }
            //交换回来了新元素之后需要重新判断该位置元素
            int temp = arr[i]; arr[i] = arr[m]; arr[m] = temp;
            i--;
        }
        return list;
    }
}
