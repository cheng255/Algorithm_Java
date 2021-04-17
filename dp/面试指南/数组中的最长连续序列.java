package com.cheng.dp.面试指南;

import java.util.HashMap;
import java.util.Scanner;

/**
 * T:给定无序数组arr
 * <p>
 * 例：arr=[100,4,200,1,3,2],最长的连续序列为[1,2,3,4],
 * 返回4
 *
 * @author nuonuo
 * @create 2021-04-16 13:48
 */
public class 数组中的最长连续序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = longestContiguousSequence(arr);
        System.out.println(res);
    }

    /**
     * 思路：使用hashmap。key：遍历的每个数   value:每个数所在的连续序列长度
     * 并且动态存放 最长连续序列的left和right和len的关系 如：   <left, len>   <right, len>
     */
    private static int longestContiguousSequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;//动态记录最大长度
        for (int value : arr) {
            if (map.containsKey(value)) {//相同的元素跳过就行了
                continue;
            }
            map.put(value, 1);//初始化长度为1，即自身。
            if (map.containsKey(value - 1)) {//存在arr[i] - 1元素，就将这两个长度合并，并且更新 left right len
                max = Math.max(max, merge(map, value - 1, value));
            }
            if (map.containsKey(value + 1)) {//存在arr[i] + 1
                max = Math.max(max, merge(map, value, value + 1));
            }
        }
        return max;
    }

    private static int merge(HashMap<Integer, Integer> map, int less, int more) {
        int left = less - map.get(less) + 1;
        int right = more + map.get(more) - 1;
        int len = right - left + 1;
        map.put(left, len);
        map.put(right, len);
        return len;
    }
}
