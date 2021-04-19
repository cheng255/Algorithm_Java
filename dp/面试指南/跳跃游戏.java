package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定数组arr, arr[i]==k 代表可以从位置i向右跳1-k个距离。比如，
 * arr[2]==3，代表从位置2可以跳到位置3，位置4或5.如果从位置0出发，
 * 返回最少跳几次能跳到arr最后的位置上。
 *
 * 例：arr=[3,2,3,1,1,4]
 * arr[0]==3,选择跳到位置2：arr[2]==3,可以跳到最后的位置，所以返回2.
 * 要求：时间复杂度 O(N)   空间复杂度 O(1)
 * @author nuonuo
 * @create 2021-04-15 22:16
 */
public class 跳跃游戏 {
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        jumpingGame(arr, 0, 0);
        System.out.println(max);
        System.out.println(jumpingGameDP(arr));
    }
    //动态规划 记录三个变量   jump表示当前跳了多少步，cur表示jump步最远能到的位置， next表示再多跳一步最远能到的位置
    private static int jumpingGameDP(int[] arr) {
        int jump = 0, cur = 0, next = 0;
        for (int i = 0; i < arr.length; i++) {
            if (cur < i) {//当前步数跳不过来了，需要再跳一步
                jump++;
                cur = next;
            }
            next = Math.max(next, i + arr[i]);
        }
        return jump;
    }

    //递归
    private static void jumpingGame(int[] arr, int k, int t) {
        if (k == arr.length-1) {
            max = Math.min(max, t);
        }
        for (int i = 1; i <= arr[k]; i++) {
            if (k + i >= arr.length) {
                break;
            }
            jumpingGame(arr, k+i, t+1);
        }
    }
}
