package com.cheng.array;

import java.util.Arrays;

/**
 * @author nuonuo
 * @create 2021-10-06 12:51
 */
public class 部分排序 {
    public static void main(String[] args) {
        int[] ints = subSort(new int[]{1,2,4,7,10,11,7,12,6,7,16,18,19});
        System.out.println(Arrays.toString(ints));
        int[] ints1 = subSort(new int[]{7,10,11,15,16,18,19});
        System.out.println(Arrays.toString(ints1));
    }

    /**
     * 看题解     双指针，    从两面分别找不符合升序和降序的最远位置
     * @param array
     * @return
     */
    public int[] subSort1(int[] array) {
        if (array == null || array.length <= 1) {
            return new int[]{-1, -1};
        }
        int m = array[0];
        int s = array[array.length - 1];
        int l = -1, r = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < m) {
                r = i;
            } else {
                m = array[i];
            }

            if (array[array.length - 1 - i] > s) {
                l = array.length - 1 - i;
            } else {
                s = array[array.length - 1 - i];
            }
        }

        return new int[]{l, r};
    }

    public static int[] subSort(int[] array) {
        if (array == null || array.length <= 1) {
            return new int[2];
        }
        int m = array[0];
        int s = Integer.MAX_VALUE;
        int l = 0, r = -1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[i-1]) {
                if (m > array[i]) {
                    r = i;
                } else {
                    m = array[i];
                }
            } else {//不符合递增
                s = Math.min(s, array[i]);
                r = i;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] > s) {
                l = i;
                break;
            }
        }
        if (r == -1) {
            return new int[2];
        }
        if (l > r) {
            l = r;
        }
        return new int[]{l, r};

    }
}
