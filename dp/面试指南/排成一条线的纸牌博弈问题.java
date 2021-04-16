package com.cheng.dp.面试指南;

import java.util.Scanner;

/**
 * T:给定一个整形数组arr，代表数值不同的纸牌排成一条线。
 * 玩家A和玩家B依次拿走每张纸牌，规定玩家A先拿，玩家B后拿，
 * 但是每个玩家每次只能拿走最左或者最右的纸牌，玩家A和玩家B都决定聪明。
 * 请返回最后获胜者的分数。
 * @author nuonuo
 * @create 2021-04-15 20:57
 */
public class 排成一条线的纸牌博弈问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = cardGameDP(arr);
        System.out.println(res);

    }

    /**
     * a[i][j]表示 arr[i~j]里先拿的结果
     * b[i][j]表示 arr[i~j]里后拿的结果
     * a[i][j]依赖于 b[i+1][j]和b[i][j-1]   b[i][j]依赖于 a[i+1][j]和a[i][j-1]
     */
    private static int cardGameDP(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] a = new int[arr.length][arr.length];
        int[][] b = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i][i] = arr[i];//只有一张
            for (int j = i-1; j >= 0; j--) {
                a[j][i] = Math.max(arr[j] + b[j+1][i], arr[i] + b[j][i-1]);
                b[j][i] = Math.min(a[j+1][i], a[j][i-1]);
            }
        }
        return Math.max(a[0][arr.length-1], b[0][arr.length-1]);

    }


    private static int cardGame(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(a(arr, 0, arr.length-1), b(arr, 0, arr.length-1));
    }

    //模拟先拿牌的人，
    private static int a(int[] arr, int l, int r) {
        if (l == r) {//还有一张牌，肯定是自己拿
            return arr[l];
        }
        return Math.max(arr[l] + b(arr, l+1, r), arr[r] + b(arr, l, r-1));//拿左边或者右边，拿完之后就作为后拿的玩家了
        // 最终结果更大的返回，
    }

    private static int b(int[] arr, int l, int r) {
        if (l == r) {//还有一张牌，肯定是别人拿了
            return 0;
        }
        return Math.min(a(arr, l+1, r), a(arr, l, r-1));//对手先拿并且聪明绝顶，所以会把较小的结果留给后拿的玩家。
    }
}
