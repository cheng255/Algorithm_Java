package day04;

import java.util.Stack;

/**
 根据 逆波兰表示法，求该后缀表达式的计算结果。
 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 说明：
 整数除法只保留整数部分。
 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 示例 1：
 输入：tokens = ["2","1","+","3","*"]
 输出：9
 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9

 思路：这个我做过很容易  用栈就解决了

 */
public class 后缀表达式036 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (Character.isDigit(s.charAt(s.length()-1))) {
                //数字
                stack.push(Integer.parseInt(s));
            } else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                switch (s.charAt(0)) {
                    case '*':
                        stack.push(n2 * n1);
                        break;
                    case '/':
                        stack.push(n2 / n1);
                        break;
                    case '+':
                        stack.push(n2 + n1);
                        break;
                    case '-':
                        stack.push(n2 - n1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
