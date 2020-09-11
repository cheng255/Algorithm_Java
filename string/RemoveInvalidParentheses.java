package com.cheng.string;

/**
 * LeetCode T 1249. 移除无效的括号
 *
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 *
 * 示例 1：
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 *
 * 示例 2：
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 *
 * 示例 3：
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 *
 * 示例 4：
 * 输入：s = "(a(b(c)d)"
 * 输出："a(b(c)d)"
 * @author nuonuo
 * @create 2020-09-11 21:29
 */
public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("())()((("));
    }
    // 1. 定义一个count 遍历到左括号 count++ 右括号 count--
    // 左括号先出现时，直接删除  // 并且count最终的值为多余的左括号的个数
    // 然后最后从字符串后面删除count个 '('
    private static String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder(s);
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            char temp = sb.charAt(i);
            if (temp == '(') {
                count++;
            } else if (temp == ')') {
                count--;
            }
            if (count < 0) {
                sb.deleteCharAt(i);
                i--;
                count++;
            }
        }
        System.out.println(sb);
        for (int i = sb.length() - 1; i >= 0; i--) {
            char temp = sb.charAt(i);
            if (temp == '(') {
                sb.deleteCharAt(i);
                count--;
            }
            if (count == 0) {
                break;
            }
        }
        return sb.toString();
    }
}
