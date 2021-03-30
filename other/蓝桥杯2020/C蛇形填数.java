package com.cheng.other.蓝桥杯2020;

/**
 * @author nuonuo
 * @create 2021-03-28 11:03
 */
public class C蛇形填数 {
    public static void main(String[] args) {
        int a = 0, b = 0;
        for (int i = 1; i <= 38; i++) {
            a += i;
            b += i;
        }
        a += 39;
        b += 1;
        int res = (a + b) / 2;
        System.out.println(res);
    }
}
