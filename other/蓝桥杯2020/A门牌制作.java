package com.cheng.other.蓝桥杯2020;

/**
 * 门牌制作
 * @author nuonuo
 * @create 2021-03-28 10:03
 */
public class A门牌制作 {
    public static void main(String[] args) {
        int res = 0;
        for (int i = 1; i <= 2020; i++) {
            int j = i;
            while (j > 0) {
                if ((j % 10) == 2) { //判断个位是否为2
                    res++;
                }
                j /= 10;//将个位去掉继续判断
            }
        }
        System.out.println(res);
    }
}
