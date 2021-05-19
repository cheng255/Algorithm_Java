package com.cheng.stackqueue;

import java.util.Stack;

/**
 * LeetCode 227基本计算器 II
 * @author nuonuo
 * @create 2021-05-18 19:29
 */
public class 基本计算器2 {
    public int calculate(String s) {
        //如果是* /就直接  stack.pop() * / num
        //如果是+ 就直接 stack.push(num)
        //如果是- 就直接 stack.push(-num)
        Stack<Integer> stack = new Stack<>();
        char lastSym = '+'; //记录上一个运算符
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                switch (lastSym) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                num = 0;
                lastSym = c;
            }
        }
        num = 0;
        while (!stack.isEmpty()) {
            num += stack.pop();
        }
        return num;
    }
}
