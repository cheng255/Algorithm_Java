package com.cheng.other.蓝桥杯2014;

import java.util.Scanner;

/**
 * 有n个小朋友围坐成一圈。老师给每个小朋友随机发偶数个糖果，然后进行下面的游戏：
 * 每个小朋友都把自己的糖果分一半给左手边的孩子。
 * 一轮分糖后，拥有奇数颗糖的孩子由老师补给1个糖果，从而变成偶数。
 * 反复进行这个游戏，直到所有小朋友的糖果数都相同为止。
 * 你的任务是预测在已知的初始糖果情形下，老师一共需要补发多少个糖果。
 * 【格式要求】
 * 程序首先读入一个整数N(2<N<100)，表示小朋友的人数。
 * 接着是一行用空格分开的N个偶数（每个偶数不大于1000，不小于2）
 * 要求程序输出一个整数，表示老师需要补发的糖果数。
 * 例如：输入
 * 3
 * 2 2 4
 * 程序应该输出：
 * 4
 * @author nuonuo
 * @create 2021-03-22 18:27
 */
public class 分糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] candy = new int[n];
        for (int i = 0; i < n; i++) {
            candy[i] = sc.nextInt();
        }
        int[] left = new int[n];
        int res = 0;
        while (true) {
            //1.每个小朋友都把自己的糖果分一半给左手边的孩子,这一步需要分成给和接两个步骤，否则会出现错误
//            candy[n-1] += candy[0] / 2;
//            candy[0] /= 2;
//            for (int i = 1; i < n; i++) {
//                candy[i-1] += candy[i] / 2;
//                candy[i] /= 2;
//            }//错误代码
            for (int i = 0; i < n; i++) {
                left[i] = candy[i] / 2;
                candy[i] /= 2;
            }//给左边糖果
            for (int i = 0; i < n; i++) {
                candy[i] += left[(i+1) % n];
            }//接收右边的糖果

            //2.拥有奇数颗糖的孩子由老师补给1个糖果
            for (int i = 0; i < n; i++) {
                if ((candy[i] & 1) != 0) {
                    candy[i] += 1;
                    res++;
                }
            }
            //3.反复进行这个游戏，直到所有小朋友的糖果数都相同为止
            boolean same = true;
            for (int i = 1; i < n; i++) {
                if (candy[i] != candy[i-1]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                break;
            }
        }
        System.out.println(res);
    }
}
