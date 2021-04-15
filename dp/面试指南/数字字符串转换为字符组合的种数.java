package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 *
 * T:给定一个字符串str，str全部由数字字符组成，如果str中某一个或某相邻两个字符
 * 组成的子串值在1~26之间，则这个子串可以转换为一个字母。规定‘1’转换为‘A’
 * '2'转换为'B' ...'26'转换为‘Z’  写一个函数，求str有多少种不同的转化结果
 *
 * 例： str="1111"。 结果可以是 "AAAA" "LAA" "ALA" "AAL" "LL"
 *          返回5.
 *      str="01"   返回0
 *      str="10"   结果只能是“J”返回1
 * @author nuonuo
 * @create 2021-04-13 13:23
 */
public class 数字字符串转换为字符组合的种数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int res = NumberTocharacterCombinations(str);
        System.out.println(res);
    }

    /**
     * 因为0开头的情况要另外考虑，所以从后往前dp
     * dp[i]表示str[i~str.length-1] 有多少种          dp[str.length] = 1
     *          if(str[i] == 0) 就是0
     *          else   dp[i] += dp[i-1]
     *          if (str[i~i+1] 可以表示1-26的话) dp 再加 dp[i-2]
     *    实际dp只需要三个变量
     */
    private static int NumberTocharacterCombinations(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] s = str.toCharArray();
        int next = 1, cur = s[str.length()-1] == '0' ? 0 : 1, temp;
        for (int i = s.length - 2; i >= 0; i--) {
            if (s[i] == '0') {
                next = cur;
                cur = 0;
            } else {
                temp = cur;
                if ((s[i]-'0') * 10 + s[i+1] - '0' < 27) {
                    cur += next;
                }
                next = temp;
            }
        }
        return cur;
    }

}
