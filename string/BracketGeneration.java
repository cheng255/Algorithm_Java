package com.cheng.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LeetCode T22 : 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * @author nuonuo
 * @create 2020-09-07 12:52
 */
public class BracketGeneration {
    public static void main(String[] args) {
        List<String> list = new BracketGeneration().generateParenthesis(3);
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
    // 思路： 递归回溯  要注意左右括号的特殊条件

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        backtracking(sb, res, 0, 0, n);
        return res;
    }

    /**
     *
     * @param sb: 用于连接括号的字符串
     * @param res
     * @param left：表示当前左括号的数量
     * @param right：表示当前右括号的数量
     * @param max：n
     */
    public void backtracking(StringBuilder sb, List<String> res, int left, int right, int max) {
        if (right == max) {
            res.add(sb.toString());
            return;
        }
        if (left < max) {
            sb.append("(");
            backtracking(sb, res, left + 1, right, max);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right < left) {
            sb.append(")");
            backtracking(sb, res, left, right + 1, max);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
