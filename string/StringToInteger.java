package com.cheng.string;

/**
 * LeetCode T8. 字符串转换整数 (atoi)
 * @author nuonuo
 * @create 2020-10-04 15:35
 */
public class StringToInteger {

    public static void main(String[] args) {
        System.out.println(myAtoi("  0000000000012345678"));
    }

    public static int myAtoi(String str) {
        String now = str.trim();
        if (now.length() == 0) { // 全是空格直接返回
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        char temp = now.charAt(0); // 判断第一个非空字符
        if ((!Character.isDigit(temp) && temp != '-' && temp != '+')) { //不是数字也不是-+
            return 0;
        }
        if (temp != '0') {
            sb.append(temp);//第一个字符符合条件
        }
        boolean flag = true;
        if (temp == '-' || temp == '+' || temp == '0') {
            if (now.length() == 1) { // 只有一个-+
                return 0;
            }
            flag = false;
        }
        for (int i = 1; i < now.length(); i++) {
            temp = now.charAt(i);
            if (Character.isDigit(temp)) {
                if (temp != '0') { // 至少有一个不等于0
                    flag = true;
                }
                if (temp == '0' && !flag) {
                    //前面的0不参于数字组合
                    continue;
                }
                sb.append(temp);
            } else { //不是数字直接退出
                break;
            }
        }
        if (!flag) { // 一个非0数字都没有
            return 0;
        }
        System.out.println(sb.toString());


        int res = check(sb.toString());
        return res;
    }

    public static int check(String s) {
        if (s.charAt(0) == '-') {
            if (s.length() > 11) {
                return (int) Math.pow(-2, 31);
            } else if (s.length() < 11) {
                return Integer.parseInt(s);
            } else {
                if ("-2147483648".compareTo(s) >= 0) {
                    return Integer.parseInt(s);
                } else {
                    return (int) Math.pow(-2, 31);
                }
            }
        } else if (s.charAt(0) == '+') {
            if (s.length() > 11) {
                return (int) (Math.pow(2, 31) - 1);
            } else if (s.length() < 11) {
                return Integer.parseInt(s);
            } else {
                if ("+2147483647".compareTo(s) >= 0) {
                    return Integer.parseInt(s);
                } else {
                    return (int) (Math.pow(2, 31) - 1);
                }
            }
        } else {
            if (s.length() > 10) {
                return (int) (Math.pow(2, 31) - 1);
            } else if (s.length() < 10) {
                return Integer.parseInt(s);
            } else {
                if ("2147483647".compareTo(s) >= 0) {
                    return Integer.parseInt(s);
                } else {
                    return (int) (Math.pow(2, 31) - 1);
                }
            }
        }
    }
}
