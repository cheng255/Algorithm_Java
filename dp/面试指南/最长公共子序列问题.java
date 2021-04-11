package com.cheng.dp.面试指南;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 返回两个字符串的最长公共子序列
 * 例子：str1="1A2C3D4B56"  str2="B1D23CA45B6A"
 * "123456"或者"12C4B6"都是最长公共子序列，返回任意一个
 *
 * @author nuonuo
 * @create 2021-04-09 8:21
 */
public class 最长公共子序列问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String res = LongestCommonSubsequence(str1, str2);
        System.out.println(res);
    }


    private static String LongestCommonSubsequence(String str1, String str2) {
        if (str1 == null || str1.length() == 0 || str2 == null || str2.length() == 0) return null;
        int[][] dp = getDp(str1, str2);
        String res = getSubsequence(str1, str2, dp);
        return res;
    }

    /**
     * dp数组的最后一个元素就是子序列的长度。
     * 从后面开始：起初 len就是子序列的长度 判断
     *              1.如果dp[i][j] == len && str1[i]==str[j]就加入容器，并且i--,j--, len--
     *              2.如果dp[i][j] == len, str1[i]!=str[j]只满足一个，说明最长子序列不包括这两个元素，
     *                就判断dp[i-1][j]和dp[i][j-1]谁等于len。
     *                      3.如果dp[i-1][j]==len则i--，继续判断str1[i]==str[j]
     *                      4.如果dp[i][j-1]==len则j--，继续判断str1[i]==str[j]
     *                          只要是相等就加入容器，同1
     */
    private static String getSubsequence(String str1, String str2, int[][] dp) {
        int len = dp[str1.length()-1][str2.length()-1];
        char[] res = new char[len];
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        while (len > 0) {
            if (dp[i][j] == len && str1.charAt(i) == str2.charAt(j)) {//1.
                res[--len] = str1.charAt(i);
                i--;
                j--;
                continue;
            }
            //2.
            if (i > 0 && dp[i-1][j] == len) {//3.
                i--;
            } else {//4.
                j--;
            }
        }
        return Arrays.toString(res);
    }

    /**
     * dp[i][j]表示到str1[i]和str2[j]为止的最长公共子序列
     * <p>
     * dp[i][j] = 1.dp[i][j-1], 2.dp[i-1][j], 如果str1[i]==str2[j]还可以是3.dp[i-1][j-1]+1
     *          三者选最大。
     */
    private static int[][] getDp(String str1, String str2) {
        int[][] dp = new int[str1.length()][str2.length()];
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        dp[0][0] = s1[0] == s2[0] ? 1 : 0;
        for (int i = 1; i < s1.length; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], s1[0] == s2[i] ? 1 : 0);
        }
        for (int i = 1; i < s1.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], s1[i] == s2[0] ? 1 : 0);
        }
        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (s1[i] == s2[j]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
            }
        }
        return dp;
    }

}
