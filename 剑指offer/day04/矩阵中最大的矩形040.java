package day04;

import java.util.Stack;

/**
 给定一个由 0 和 1 组成的矩阵 matrix ，找出只包含 1 的最大矩形，并返回其面积。
 注意：此题 matrix 输入格式为一维 01 字符串数组。
 输入：matrix = ["10100","10111","11111","10010"]
 输出：6
 解释：最大矩形如上图所示。
 示例 2：

 输入：matrix = []
 输出：0

 思路：  其实就是求n个直方图最大矩形面积  如果有n行，就是n个
        用个dp数组来保存高度的变化就行


 */
public class 矩阵中最大的矩形040 {
    public int maximalRectangle(String[] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[] dp = new int[matrix[0].length()];//记录以第i行为低的各列高度
        //初始化为0
        for (int i = 0; i < matrix.length; i++) {//给以第i行为底的各列高度求最大矩形
            //这里面就是直方图求面积的逻辑
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            for (int j = 0; j < matrix[0].length(); j++) {
                dp[j] = matrix[i].charAt(j) == '0' ? 0 : dp[j] + 1;

                while (stack.peek() != -1 && dp[stack.peek()] > dp[j]) {
                    res = Math.max(res, dp[stack.pop()] * (j - stack.peek() - 1));
                }
                stack.push(j);
            }
            while (stack.peek() != -1) {
                res = Math.max(res, dp[stack.pop()] * (dp.length - stack.peek() - 1));
            }
            //System.out.println(Arrays.toString(dp));
        }
        return res;
    }
}
