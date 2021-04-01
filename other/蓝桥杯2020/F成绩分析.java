package com.cheng.other.蓝桥杯2020;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2021-03-28 14:39
 */
public class F成绩分析 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double sum = 0;
        int max = 0; int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            max = Math.max(max, num);
            min = Math.min(min, num);
            sum += num;
        }
        System.out.println("max = " + max);
        System.out.println("min = " + min);
        System.out.println("average = " + String.format("%.2f",sum / n));
    }
}
