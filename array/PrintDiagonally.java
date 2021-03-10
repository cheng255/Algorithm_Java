package com.cheng.array;

/**
 * 实现从右上角到左下角沿着主对角线方向进行打印
 *
 * @author nuonuo
 * @create 2021-03-10 17:05
 */
public class PrintDiagonally {
    public static void main(String[] args) {

    }
    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] res = new int[n*n];
        int index = 0;
        int x = 0;
        int y = n - 1;
        for (int i = 0; i < 2*n-1; i++) {
            int xx = x;
            int yy = y;
            if (i < n - 1) {//上半部分
                while (yy < n) {
                    res[index++] = arr[xx][yy];
                    xx++;
                    yy++;
                }
                xx = x;
                yy = y - 1;
                y = yy;
            } else {
                while (xx < n) {
                    res[index++] = arr[xx][yy];
                    xx++;
                    yy++;
                }
                xx = x + 1;
                x = xx;
                yy = y;
            }

        }
        return res;
    }
}
