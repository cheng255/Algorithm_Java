package com.cheng.dp.面试指南;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author nuonuo
 * @create 2021-04-09 9:36
 */
public class 最长公共子串问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String s = LongestCommonSubstringNB(str1, str2);
        System.out.println(s);
    }

    /**
     *改为空间复杂度为O(1)的方法
     *  之前的dp二维数组，因为dp[i][j]只和dp[i-1][j-1]的值有关，所以斜着遍历，就可以只需要一个变量就可以完成dp
     *  也就是借助要斜着遍历二维数组的思想
     */
    private static String LongestCommonSubstringNB(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int max = -1;
        int index = -1;
        int r = 0;
        int c = s2.length - 1;
        int n = s1.length + s2.length - 1;//一种有n条斜线
        for (int i = 0; i < n; i++) {
            int pre = 0;//总是表示dp斜线上前一个
            //一条斜线的遍历
            int row = r;
            int column = c;
            while (column < s2.length && row < s1.length) {
                pre = s1[row] == s2[column] ? pre + 1 : 0;
                if (pre > max) {
                    index = row;
                    max = pre;
                }
                row++;
                column++;
            }
            if (c == 0) {
                r++;
            } else {
                c--;
            }
        }
        System.out.println(max);
        char[] res = new char[max];
        for (int i = max - 1; i >= 0; i--) {
            res[i] = s1[index--];
        }
        return Arrays.toString(res);
    }

    private static String LongestCommonSubstring(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int[][] dp = new int[s1.length][s2.length];
        int max = getDp(s1, s2, dp);
        //得到序列
        //首先找到dp中的max所在位置,然后就出现结果了
        int i;
        A: for (i = s1.length-1; i >= 0; i--) {
            for (int j = s2.length-1; j >= 0; j--) {
                if (dp[i][j] == max) {
                    //找到了
                    break A;
                }
            }
        }
        return str1.substring(i - max + 1, i + 1);
    }
    /**
     * dp[i][j]表示以ij结尾的最长公共子串
     *
     */
    public static int getDp(char[] A, char[] B, int[][] dp) {
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (B[0] == A[i]) {
                dp[i][0] = 1;
                max = 1;
            }

        }
        for (int i = 0; i < B.length; i++) {
            if (B[i] == A[0]) {
                dp[0][i] = 1;
                max = 1;
            }

        }
        for (int i = 1; i < A.length; i++) {
            for(int j = 1; j < B.length; j++) {
                if (A[i] == B[j]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max;
    }

}
