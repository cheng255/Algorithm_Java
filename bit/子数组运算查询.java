package com.cheng.bit;

/**
 * Leetcode 1310.
 * 思想：
 *      异或运算 前缀和原理
 *
 *
 * @author nuonuo
 * @create 2021-05-12 23:24
 */
public class 子数组运算查询 {
    public int[] xorQueries(int[] arr, int[][] queries) {

        //1.先得到以每一个元素结尾的前缀异或和
        int[] xors = new int[arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            xors[i+1] = xors[i] ^ arr[i];
        }
        //2.   res[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return res;
    }
}
