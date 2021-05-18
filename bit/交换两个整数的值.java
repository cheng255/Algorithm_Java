package com.cheng.bit;

/**
 * 不适用变量交换两个数的值
 * @author nuonuo
 * @create 2021-05-17 11:40
 */
public class 交换两个整数的值 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;

        //使用 ^ 异或运算符
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a + ", " + b);
    }
}
