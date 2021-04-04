package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:数组arr每个值代表一种面值的货币，每种纸币可以用任意张，求组成aim的最少货币数
 * <p>
 * 补充T:每个纸币只能是一张
 *
 * @author nuonuo
 * @create 2021-04-03 9:18
 */
public class 换钱的最小货币数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        System.out.println(combine(arr, aim));
        System.out.println(combine补充(arr, aim));
    }

    //补充题目
    private static int combine补充(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return -1;
        }
        //1.dp[i][j]表示用前i+1张纸币组成j的最小张数
        int[][] dp = new int[arr.length][aim + 1];
        //初始化   dp[i][0] = 0    dp[0][j] 表示只用第一张钱组成aim的最小张数
        //比如 arr[0] = 2   那么   除了dp[0][2] = 1;  其他全用Integer.MAX_VALUE填充
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
        }
        if (arr[0] <= aim) {
            dp[0][arr[0]] = 1;
        }
        //2.递推公式 dp[i][j] = Min(dp[i-1][j], dp[i-1][j-arr[i]]+1)
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i - 1][j - arr[i]] != max) {
                    left = dp[i - 1][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[arr.length - 1][aim] != max ? dp[arr.length - 1][aim] : -1;
    }

    private static int combine(int[] arr, int aim) {
        //1.dp[i][j]表示用前i+1张纸币组成j的最小张数
        int[][] dp = new int[arr.length][aim + 1];
        //初始化   dp[i][0] = 0    dp[0][j] 表示只用第一张钱组成aim的最小张数,
        //比如arr[0] = 2;那么dp[0][2] = 1   dp[0][4] = 2...; 其他的值用Integer.MAX_VALUE填充
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= aim; i++) {
            dp[0][i] = max;
            if (i - arr[0] >= 0 && dp[0][i - arr[0]] != max) {
                dp[0][i] = dp[0][i - arr[0]] + 1;
            }
        }
        //2.//枚举出下标为i的这张钱有0，1，2,3...张，找出最小的
        // 经过推导 dp[i][j] = Min(dp[i-1][j], dp[i][j-arr[i]]+1)
        int left = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                left = max;
                if (j - arr[i] >= 0 && dp[i][j - arr[i]] != max) {
                    left = dp[i][j - arr[i]] + 1;
                }
                dp[i][j] = Math.min(left, dp[i - 1][j]);
            }
        }
        return dp[arr.length - 1][aim] != max ? dp[arr.length - 1][aim] : -1;
    }
}
