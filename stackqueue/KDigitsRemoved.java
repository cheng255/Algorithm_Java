package com.cheng.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉K位数字
 *
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 * 注意:
 *
 * num 的长度小于 10002 且 ≥ k。
 * num 不会包含任何前导零。
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是0。
 * @author nuonuo
 * @create 2020-11-15 14:47
 */
public class KDigitsRemoved {

    public static void main(String[] args) {

    }

    /**
     * LeetCode官方： 找到最高位最大的元素删除
     */
    class Solution {
        public String removeKdigits(String num, int k) {
            //思路：使用栈  遍历并入栈 当遍历到num[i-1] > num[i]时，删除栈顶元素num[i-1]直到栈顶元素小于等于num[i]然后num[i]入栈，最后栈中就是最小的字符序列
            if (num == null || num.length() == 0) {
                return "0";
            }
            if (k == 0) {
                return num;
            }
            Deque<Character> stack = new LinkedList<>();
            boolean flag = true;
            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                while (flag && !stack.isEmpty() && stack.peek() > c) {//如果逆序就一直删
                    stack.pop();
                    k--;
                    if (k == 0) {
                        //删够了
                        flag = false;
                    }
                }
                stack.push(c);//当前元素入栈
            }
            //没删够 从后往前删
            while (k > 0) {
                --k;
                stack.pop();
            }
            //删完后 出栈返回结果  注意检查前置0
            StringBuilder sb = new StringBuilder();
            boolean flag1 = true;
            while (!stack.isEmpty()) {
                char c = stack.pollLast();
                if (flag1 && c == '0') {
                    continue;
                }
                flag1 = false;
                sb.append(c);
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }

    }

    /**
     * 我自己的方法 从最高位每次选最小的数加入
     */

    class Solution1 {
        int min = 0;
        public String removeKdigits(String num, int k) {
            int len = num.length() - k;
            if (len <= 0) {
                return "0";
            }
            StringBuilder sb = new StringBuilder(num);
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < len; i++) {
                Character c = findMin(sb,sb.length() - len + i + 1);//找到最小值
                if (c == null) {
                    break;
                }
                res.append(c);
            }
            while (res.length() != 0 && res.charAt(0) == '0') {
                res.deleteCharAt(0);
            }
            if (res.length() == 0) {
                return "0";
            }
            return res.toString();

        }
        private Character findMin(StringBuilder sb, int len) {
            if (len <= 0) {
                return null;
            }
            for (int i = min; i < len; i++) {
                if (sb.charAt(i) < sb.charAt(min)) {
                    min = i;
                }
            }
            char res = sb.charAt(min);
            sb.deleteCharAt(min);
            return res;
        }
    }
}
