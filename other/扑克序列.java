package com.cheng.other;

import java.util.*;

/**
 * A A 2 2 3 3 4 4， 一共4对扑克牌。请你把它们排成一行。
 * 要求：两个A中间有1张牌，两个2之间有2张牌，两个3之间有3张牌，两个4之间有4张牌。
 * 请填写出所有符合要求的排列中，字典序最小的那个。
 * 例如：22AA3344 比 A2A23344 字典序小。当然，它们都不是满足要求的答案。
 * <p>
 * 思路：全排列 -> 然后判断符合要求 -> 然后排序选字典序最小
 *
 * @author nuonuo
 * @create 2021-03-22 18:55
 */
public class 扑克序列 {
    private static List<String> fullArray = new ArrayList<>();
    private static List<String> res = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "AA223344";
        full(s.toCharArray(), 0);//1.全排列
        filter();//2.筛选符合要求的
        Collections.sort(res);//3.排序
        System.out.println(res.get(0));

    }

    //筛选逻辑  每个字符都有两个，使用map记录遇到第一个字符时的下标，当第二次遇到时判断 下标之差是否符合要求。
    private static void filter() {
        //首先把不同字符的需要的间隔记录下来
        Map<Character, Integer> interval = new HashMap<>();
        interval.put('A', 2);
        interval.put('2', 3);
        interval.put('3', 4);
        interval.put('4', 5);

        for (int i = 0; i < fullArray.size(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = fullArray.get(i).toCharArray();
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                if (!map.containsKey(chars[j])) {//第一次遇到直接加入map
                    map.put(chars[j], j);
                } else if (j - map.get(chars[j]) != interval.get(chars[j])) {//第二次遇到并且不符合要求,就直接看下一个全排列
                    flag = false;
                    break;
                }
            }
            if (flag) {//符合要求
                res.add(String.valueOf(chars));
            }
        }
    }

    //全排列逻辑：将每一位依次和他后面的每一位字符调换位置
    private static void full(char[] chars, int k) {
        if (k == chars.length) {
            fullArray.add(String.valueOf(chars));
            return;
        }
        for (int i = k; i < chars.length; i++) {
            swap(chars, i, k);//将k位置的数据换到k+1，k+2....
            full(chars, k + 1);//递归
            swap(chars, i, k);//回溯
        }
    }

    private static void swap(char[] chars, int i, int k) {
        char c = chars[i];
        chars[i] = chars[k];
        chars[k] = c;
    }
}
