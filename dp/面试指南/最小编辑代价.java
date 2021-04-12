package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入，
 * 删除和替代一个字符的代价，返回将str1编辑成str2的最小代价。
 *
 * 例：str1="abc"  str2="adc",ic=5,dc=3,rc=2,结果为2
 *      str1="ab12cd3"    str2="abcdf"  ic,dc,rc  :  5 3 2     结果为8
 * @author nuonuo
 * @create 2021-04-11 13:26
 */
public class 最小编辑代价 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        int ic = sc.nextInt();
        int dc = sc.nextInt();
        int rc = sc.nextInt();
        int res = minEditingCostNB(str1, str2, ic, dc, rc);
        System.out.println(res);
    }

    /**
     * dp[i][j]表示  到str1[i-1]为止，编辑成str2[j-1] 所需要的最小代价。  0下标表示""空串
     *      dp[0][0]=0     dp[0][j]= j*ic        dp[i][0]=i*dc
     *      其他位置    dp[i][j]:   1.如果str[i]==str[j]，那么就等于dp[i-1][j-1]    用str1[0~i-1]编辑str2[0~i-1]
     *                             2.dp[i-1][j] + dc   用str1[0~i-2]编辑str2[0~i-1],把当前字符删掉
     *                             3.如果str[i]!=str[j],dp[i-1][j-1] + rc    用str1[0~i-2]编辑str2[0~i-2],把当前字符替换为str2[j-1]
     *                             4.dp[i][j-1] + ic   用str1[0~i-1]编辑str2[0~j-2],再添加str2[j-1]
     *         四种可能选择最小的值作为dp[i][j]
     */
    private static int minEditingCost(String s1, String s2, int ic, int dc, int rc) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int[][] dp = new int[str1.length][str2.length];
        for (int i = 1; i < str2.length; i++) {
            dp[0][i] = dp[0][i-1] + ic;
        }
        for (int i = 1; i < str1.length; i++) {
            dp[i][0] = dp[i-1][0] + dc;
        }
        for (int i = 1; i < str1.length; i++) {
            for (int j = 1; j < str2.length; j++) {
                dp[i][j] = dp[i-1][j-1];
                if (str1[i] != str2[j]) dp[i][j] += rc;
                dp[i][j] = Math.min(Math.min(dp[i-1][j] + dc, dp[i][j-1] + ic), dp[i][j]);
            }
        }
        return dp[str1.length-1][str2.length-1];
    }

    /**
     * 改成空间复杂度为min(M,N)的
     *
     * dp[i][j]依赖的有 dp[i][j-1]  dp[i-1][j]  dp[i-1][j-1]
     * 如果str2长度更短。
     * dp[j]更新之前就是代表dp[i-1][j]      dp[j-1]就代表dp[i][j-1]     需要有一个值来表示dp[i-1][j-1],沒更新前的dp[j-1]就可以表示
     */
    private static int minEditingCostNB(String s1, String s2, int ic, int dc, int rc) {
        if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return 0;
        }
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();
        int column = Math.min(str1.length, str2.length) + 1;//列
        int row = (column == str1.length ? str2.length : str1.length) + 1;//行
        boolean str1IsRow = row == str1.length + 1;
        int[] dp = new int[column];
        int temp = 0;//表示左上角的数
        //第一行初始化
        for (int i = 1; i < column; i++) {
            dp[i] += ic;
        }
        for (int i = 1; i < row; i++) {
            temp = dp[0];
            dp[0] += dc;//每一行第一個元素
            for (int j = 1; j < column; j++) {
                int min = 0;
                if ((str1IsRow && str1[i-1] == str2[j-1]) || (!str1IsRow && str1[j-1] == str2[i-1])) {
                    min = temp;
                } else {
                    min = temp + rc;
                }
                min = Math.min(min, Math.min(dp[j-1] + ic, dp[j] + dc));
                temp = dp[j];
                dp[j] = min;
            }
        }
        return dp[column-1];
    }

}
