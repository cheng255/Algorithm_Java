package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定数组arr， 所有的值都为整数且不重复。每个值代表一种面值的货币，每种
 * 面值的货币可以使用任意张。再给定一个整数aim代表要找的钱数，求换钱的方法有多少种
 * <p>
 * 例：arr = [5,10,25,1] aim = 15
 * 返回6
 *
 * @author nuonuo
 * @create 2021-04-05 14:46
 */
public class 换钱的方法数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aim = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(changeMoneyNB(arr, aim));
    }

    /***
     *最优解：时间复杂度 O(n*aim)  空间复杂度O(aim)
     */
    private static int changeMoneyNB(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int i = 0; i * arr[0] <= aim; i++) {
            dp[i * arr[0]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
//            dp[0] = 1; 不改过，所以永远是1
            for (int j = 1; j <= aim; j++) {
                //这里dp[j] 默认就是上一轮的
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }

    /**
     * dp[i][j] 表示用前i张组成j有多少种方法
     * dp[i][0] = 1  （组成0元的方法就是什么都不用，一种方法）
     * dp[0][j] =    （如果j%i == 0 , dp[0][j] = 1,  否则 dp[0][j] = 0）
     * 其他位置  dp[i][j] = sum( dp[i-1][j-k*arr[i]] )(k >= 0)
     * 因为    sum (dp[i-1][j-k*arr[i]] )(k >= 1)  ==>   dp[i][j-arr[0]]
     * 所以    dp[i][j] = dp[i-1][j] + dp[i][i-arr[0]]
     */
    private static int changeMoney(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length][aim + 1];
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i * arr[0] <= aim; i++) {
            dp[0][i * arr[0]] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[arr.length - 1][aim];
    }
}
