package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定一个只由0(假)，1(真)，&(逻辑与),|(逻辑或) 和  ^ (异或) 五个字符组成
 * 的字符串express，再给定一个布尔值desired。返回express能有多少种组合方式，
 * 可以达到desired的结果。
 *
 * @author nuonuo
 * @create 2021-04-14 19:25
 */
public class 表达式得到期望结果的组成种数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String express = sc.next();
        boolean desired = sc.nextBoolean();
        int res = numberOfSpecies(express, desired);
    }

    private static int numberOfSpecies(String express, boolean desired) {
        if (express == null || express.length() == 0 || !isQualified(express)) {
            return 0;
        }
        char[] exp = express.toCharArray();
        int[][] t = new int[exp.length][exp.length];//t[i][j]表示express[i~j]有多少种true
        int[][] f = new int[exp.length][exp.length];//f[i][j]表示express[i~j]有多少种false
        t[0][0] = exp[0] == '1' ? 1 : 0;
        f[0][0] = exp[0] == '0' ? 1 : 0;
        for (int i = 2; i < exp.length; i += 2) {
            t[i][i] = exp[i] == '1' ? 1 : 0;
            f[i][i] = exp[i] == '0' ? 1 : 0;
            for (int j = i - 2; j >= 0; j -= 2) {
                for (int k = j; k < i; k += 2) {
                    if (exp[k + 1] == '&') {
                        t[j][i] += t[j][k] * t[k + 2][i];
                        f[j][i] += (t[j][k] + f[j][k]) * f[k + 2][i] + f[j][k] * t[k + 2][i];
                    } else if (exp[k + 1] == '|') {
                        t[j][i] += (t[j][k] + f[j][k]) * t[k + 2][i] + t[j][k] * f[k + 2][i];
                        f[j][i] += f[j][k] * f[k + 2][i];
                    } else {
                        t[j][i] += t[j][k] * f[k+2][i] + f[j][k] * t[k+2][i];
                        f[j][i] += t[j][k] * t[k+2][i] + f[j][k] * f[k+2][i];
                    }
                }
            }
        }
        return desired ? t[0][exp.length - 1] : f[0][exp.length - 1];
    }

    //满足条件的要求有  1.长度是奇数   2.下标为偶数的是0/1    3.下标为奇数的是 三个符号之一
    private static boolean isQualified(String express) {
        if ((express.length() & 1) == 0) {
            return false;
        }
        for (int i = 0; i < express.length(); i += 2) {
            if (express.charAt(i) != '0' && express.charAt(i) != '1') {
                return false;
            }
        }
        for (int i = 1; i < express.length(); i += 2) {
            if (express.charAt(i) != '&' && express.charAt(i) != '|' && express.charAt(i) != '^') {
                return false;
            }
        }
        return true;
    }
}
