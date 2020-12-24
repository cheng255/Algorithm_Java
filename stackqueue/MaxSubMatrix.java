package com.cheng.stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * 求最大子矩阵   例如  1 1 0 1   最大为
 *                    1 1 1 1      1 1 1
 *                    1 1 1 0      1 1 1
 *
 *                    栈在往两边扩展寻找最近的最大最小值中应用
 * @author nuonuo
 * @create 2020-12-24 11:46
 */
public class MaxSubMatrix {
    public static void main(String[] args) {
        System.out.println(getMaxSubMatrix(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1},}));
    }
    /**
     * 思路：1.分别选择每一行为底 创建一个数组high high[i]记录以当前行为底时当前列的高度（连续1的个数）存的是该列的高度
     *      如：   以第一行为底时 high[] = {1 1 0 1}
     *              第二行为底时 high[] = {2 2 1 2}
     *              第三行为底时 high[] = {3 3 2 0}
     *      2.用每次得到的high数组来找到最大的矩阵
     *
     * @param matrix
     */
    private static int getMaxSubMatrix(int[][] matrix) {
        int[] high = new int[matrix[0].length];
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    high[j]++;
                    continue;
                }
                //如果是0
                high[j] = 0;
            }
            //以这一行为底的high数组初始化完成
            int num = maxMaxTrix(high);
            res = Math.max(num, res);
            System.out.println(Arrays.toString(high));
            System.out.println(num);
        }
        return res;
    }

    /**
     * 根据high数组找出最大的1矩阵的大小
     * 思路：每列都往左右两边扩，扩到最远的时候就可以算出该列扩出来的矩阵的大小
     *   具体使用栈来操作，栈中从顶到底存放递减序列的下标
     * @param high
     * @return
     */
    private static int maxMaxTrix(int[] high) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        int right = 0; int left = 0;//记录扩到的位置
        int temp = 0;int top = 0;
        for (int i = 0; i < high.length; i++) {
            while (!stack.isEmpty() && high[stack.peek()] >= high[i]) {
                top = stack.pop();//不符合栈只存放从顶到底存放递减序列的下标的规则，所以弹出栈顶元素
                if (high[top] > high[i]) {
                    //1.栈顶列高度大于当前列高度   -> 栈顶元素的扩展范围已经得到
                    if (!stack.isEmpty()) {//当前栈顶元素就是栈中最后一个元素，那么向左能扩到最左边
                        left = stack.peek()+1;
                    } else {
                        left = 0;
                    }
                    right = i - 1;
                    temp = high[top]*(right - left + 1);
                    res = Math.max(temp, res);
                }
                //2.栈顶列高度等于当前列高度  ->  栈顶列和当前列扩出来的矩阵是同一个，所以不用管，等到当前列出栈时再确定矩阵
            }
            //3.栈顶列高度小于当前列高度 -> 符合栈存放要求  , 将当前列存入栈
            stack.push(i);
        }
        //4.栈中还剩从顶到底为递减序列的下标,
        right = stack.peek();//当前栈中所有元素都能向右扩到栈顶元素位置
        while (!stack.isEmpty()) {
            top = stack.pop();
            if (!stack.isEmpty()) {
                left = stack.peek()+1;
            } else {
                left = 0;
            }
            temp = high[top]*(right - left + 1);
            res = Math.max(temp, res);
        }
        return res;
    }
}
