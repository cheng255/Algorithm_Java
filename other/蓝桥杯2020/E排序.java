package com.cheng.other.蓝桥杯2020;

/**
 * @author nuonuo
 * @create 2021-03-28 14:27
 */
public class E排序 {
    public static void main(String[] args) {
        int c = 0;
        int n;
        for (n = 1; n < 100; n++) {
            c += n - 1;
            if (c >= 100) {
                break;
            }
        }
        System.out.println("c = " + c);
        System.out.println("b = " + n);

    }
}
