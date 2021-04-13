package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定三个字符串str1，str2，aim，如果aim包含且仅包含来自str1，str2的所有字符，
 * 而且在aim中属于str1的字符之间保持原来的str1中的顺序，属于str2的字符之间保持原来的
 * str1中的顺序，那么称aim是str1和str2的交错组成。实现一个函数，判断aim是否是str1和
 * str2交错组成。
 *例： str1="AB",str2="12" 那么"AB12" "A12B" "1AB2" "1AB2"都算
 * @author nuonuo
 * @create 2021-04-12 13:27
 */
public class 字符串的交错组成 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        String aim = sc.next();
        boolean res = isStaggeredComposition(str1, str2, aim);
        System.out.println(res);
    }

    /**
     * aim 的长度为str1.length() + str2.length()
     * dp[0][0]=true;
     * dp[i][j]表示aim[0~j+i-1]是否可以由str1[0~i-1]和str2[o_j-1]交错组成
     * dp[0][j]：就只看str2组成aim的情况  dp[i][0]：就只看str1组成aim的情况
     *
     * 其他位置dp[i][j]
     *          1.dp[i-1][j] && str1[i-1] == aim[i+j-1]
     *          2.dp[i][j-1] && str2[j-1] == aim[i+j-1]
     *          3.都不符合就是false
     *
     */
    private static boolean isStaggeredComposition(String str1, String str2, String ai) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] aim = ai.toCharArray();
        if (s1.length + s2.length != aim.length) {//长度不对
            return false;
        }
        boolean[][] dp = new boolean[s1.length + 1][s2.length + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s2.length; i++) {
            if (s2[i-1] != aim[i-1]) {
                break;//因为如果前面的是false，后面的肯定都是false
            }
            dp[0][i] = true;
        }
        for (int i = 1; i <= s1.length; i++) {
            if (s1[i-1] != aim[i-1]) {
                break;
            }
            dp[i][0] = true;
        }
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                dp[i][j] = (dp[i-1][j] && s1[i-1] == aim[i+j-1]) || (dp[i][j-1] && s2[j-1] == aim[i+j-1]);
            }
        }
        return dp[s1.length][s2.length];
    }

    /**
     * 空间复杂度改成O(Min(N,M))   dp[i][j]依赖dp[i-1][j]（没更新前的自己） 和 dp[i][j-1]（前一个）
     */
    private static boolean isStaggeredCompositionNB(String str1, String str2, String ai) {
        char[] shorts = str1.length() < str2.length() ? str1.toCharArray() : str2.toCharArray();
        char[] longs = str1.length() >= str2.length() ? str1.toCharArray() : str2.toCharArray();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        char[] aim = ai.toCharArray();
        if (shorts.length + longs.length != aim.length) {//长度不对
            return false;
        }
        boolean[] dp = new boolean[shorts.length+1];
        dp[0] = true;
        for (int i = 1; i <= shorts.length; i++) {
            if (shorts[i-1] != aim[i-1]) {
                break;//因为如果前面的是false，后面的肯定都是false
            }
            dp[i] = true;
        }
        for (int i = 1; i <= longs.length; i++) {
            dp[0] = dp[0] && longs[i-1] == aim[i-1];
            for (int j = 1; j <= shorts.length; j++) {
                dp[j] = (dp[j] && longs[i-1] == aim[i+j-1]) || (dp[j-1] && shorts[j-1] == aim[i+j-1]);
            }
        }
        return dp[shorts.length];
    }
}
