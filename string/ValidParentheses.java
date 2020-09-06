package com.cheng.string;

import java.util.Stack;

/**
 * leetCode T20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValid("(()[)]{}"));
    }
    private static boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i= 0; i < s.length(); i++) {
            //左括号直接入栈
            // 右括号 就和栈顶进行匹配， 如果匹配失败直接false 成功则弹出栈顶括号
            char temp = s.charAt(i);
            if (temp == '('){
                stack.push(')');
            } else if (temp == '{') {
                stack.push('}');
            } else if (temp == '[') {
                stack.push(']');
            } else { //右括号
                if (stack.empty() || temp != stack.pop()) { // 匹配失败
                    return false;
                }
            }
        }
        // 如果当前栈中还有元素，则不正确   如： ((
        return stack.empty();
    }
}
