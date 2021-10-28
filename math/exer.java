package com.cheng.math;

import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2020-10-21 13:01
 */
public class exer {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            System.out.println(hexTo10(scanner.nextLine()));
        }
    }
    //16进制字符串转10进制数字  F 15  3F  3*16+15   33F   (3*16+3)*16+15
    private static long hexTo10(String str) {
        long res = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            res = (res + charToInt(c)) * 16;
        }
        return res / 16;
    }
    private static int charToInt(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        return c - 'A' + 10;

    }

}
