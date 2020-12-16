package com.cheng.stackqueue;

import java.util.Stack;

/**
 * T：设计一个有getMin操作的栈
 * @author nuonuo
 * @create 2020-12-16 13:25
 */
public class GetMinStack {
    /**
     * 一共两种方法，详情看书
     */

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;//记录当前最小的数

    public GetMinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int val) {
        stack1.push(val);
        if (stack2.isEmpty()) {
            stack2.push(val);
            return;
        }
        //比栈顶大的数不加入栈
        if (stack2.peek() < val) {
            return;
        }
        //小于或者相等的数加入栈
        stack2.push(val);
    }
    public int pop() {
        if (stack1.isEmpty()) {
            throw new RuntimeException("the stack is empty");
        }
        int r = stack1.pop();
        if (stack2.peek() == r) {
            stack2.pop();
        }
        return r;
    }

//    public void push(int val) {
//        stack1.push(val);
//        //如果s2为空
//        if (stack2.isEmpty()) {
//            stack2.push(val);
//            return;
//        }
//        if (stack2.peek() > val) {
//            stack2.push(val);
//            return;
//        }
//        stack2.push(stack2.peek());
//    }
//    public int pop() {
//        if (stack1.isEmpty()) {
//            throw new RuntimeException("栈为空");
//        }
//        stack2.pop();
//        return stack1.pop();
//    }
    public int getMin() {
        return stack2.peek();
    }

    public static void main(String[] args) {
        GetMinStack s = new GetMinStack();
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(1);
        s.push(2);
        s.push(1);
        s.pop();
        System.out.println(s.getMin());        s.pop();
        System.out.println(s.getMin());        s.pop();
        System.out.println(s.getMin());        s.pop();
        System.out.println(s.getMin());        s.pop();
        System.out.println(s.getMin());

    }
}
