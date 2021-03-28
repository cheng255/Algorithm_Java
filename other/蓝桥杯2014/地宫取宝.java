package com.cheng.other.蓝桥杯2014;

import java.util.Scanner;

/**
 * 数据格式】
 * 输入一行3个整数，用空格分开：n m k (1<=n,m<=50, 1<=k<=12)
 * 接下来有 n 行数据，每行有 m 个整数 Ci (0<=Ci<=12)代表这个格子上的宝物的价值
 * 要求输出一个整数，表示正好取k个宝贝的行动方案数。该数字可能很大，输出它对 1000000007 取模的结果。
 * 地宫取宝
 * 例如，输入：
 * 2 2 2
 * 1 2
 * 2 1
 * 程序应该输出：
 * 2
 *
 * @author nuonuo
 * @create 2021-03-21 11:08
 */
public class 地宫取宝  {
    private static int n;
    private static int m;
    private static int k;
    private static long[][][][] memory = new long[50][50][14][14];//记录的是这个状态下的不同的取宝方法数
    private static int[][] map = new int[50][50];

    //有四种递归路线   拿/不拿    +    往右/往下
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        //初始化宝藏地图
        for (int i = 0; i < n; i++) {
            for (int i1 = 0; i1 < m; i1++) {
                map[i][i1] = sc.nextInt();
            }
        }
        //初始化记忆数组
        for (int i = 0; i < 50; i++) for (int j = 0; j < 50; j++)
                for (int l = 0; l < 14; l++) for (int o = 0; o < 14; o++) memory[i][j][l][o] = -1;
        long res = process(map, 0, 0, -1, 0);//宝藏的最小值为0, 所以初始的max值为-1
        System.out.println(res);
    }

    private static long process(int[][] map, int x, int y, int max, int cur) {
        //递归的出口，1.这种状态出现过，2.角标越界了 3. 刚走到右下角
        if (memory[x][y][max+1][cur] != -1) {//到xy位置时，手里宝藏数量和最大宝藏这种状态出现过，直接返回结果
            return memory[x][y][max+1][cur];
        }//1
        if (x >= n || y >= m || cur > k) {
            return 0;
        }//2
        int value = map[x][y];
        if (x == n - 1 && y == m - 1) {
            if (cur == k || (value > max && cur == k - 1)) {//加或不加正好k个宝藏，就表示这是一种正确的结果
                return 1;
            }
            return 0;
        }//3
        //否则就递归把结果算出来， 分为  拿/不拿    +    往右/往下  四种
        long res = 0;
        if (value > max) {
            res += process(map,x + 1, y, value, cur + 1) % 1000000007;
            res += process(map,x, y + 1, value, cur + 1) % 1000000007;
        }
        res += process(map,x + 1, y, max, cur) % 1000000007;
        res += process(map,x, y + 1, max, cur) % 1000000007;

        memory[x][y][max + 1][cur] = res;//将这个状态存入memory， 注意 max+1位置表示max    所以  0位置表示max = -1
        return res;
    }
}
