package com.cheng.面试金典;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author nuonuo
 * @create 2021-08-11 10:26
 */
public class 括号 {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        func(n, n, 0, new StringBuilder());
        return res;
    }

    /**
     *
     * @param left 左括号剩余的数量
     * @param right 右括号剩余的数量
     * @param moreLeft 当前左括号多出右括号的数量
     * @param sb 用于记录结果和回溯的String
     */
    public void func(int left, int right, int moreLeft, StringBuilder sb) {
        if (right == 0) {
            res.add(new String(sb));
            return;
        }
        if (left == 0) {
            sb.append(")");
            func(left, right-1, moreLeft-1, sb);
            sb.deleteCharAt(sb.length()-1);
            return;
        }
        if (moreLeft > 0) {
            sb.append(")");
            func(left, right-1, moreLeft-1, sb);
            sb.deleteCharAt(sb.length()-1);
        }
        sb.append("(");
        func(left-1, right, moreLeft+1, sb);
        sb.deleteCharAt(sb.length()-1);

    }
}
