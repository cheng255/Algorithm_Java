package com.cheng.string;

/**
 * LeetCode T415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 提示：
 *
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 * @author nuonuo
 * @create 2020-09-14 20:03
 */
public class StringAddition {
    public static void main(String[] args) {
        System.out.println(addStrings("86499", "10"));
    }
    public static String addStrings(String num1, String num2) {
        if (num1 == null || num1.length() == 0) {
            return num2;
        }
        if (num2 == null || num2.length() == 0) {
            return num1;
        }
        StringBuilder sb = new StringBuilder();
        int ten = 0;
        int n;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                n = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + ten;
                i--;
                j--;
            } else if (i >= 0) {
                n = num1.charAt(i) - '0' + ten;
                i--;
            } else {
                n = num2.charAt(j) - '0' + ten;
                j--;
            }
            ten = n / 10;
            sb.append(n % 10);
        }
        if (ten != 0) {
            sb.append(ten);
        }
        sb.reverse();
        return sb.toString();
    }
}
