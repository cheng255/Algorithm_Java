package com.cheng.stackqueue;

import java.util.Stack;

/**
 * 使用栈和递归函数实现栈的逆序
 *
 * @author nuonuo
 * @create 2020-12-17 22:40
 */
public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        System.out.println(stack);
    }

    private static void reverseStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        //逆序栈操作  总是取出栈底元素，将其他元素逆序之后，将该元素重新压入栈
        int last = getAndDeleteLast(stack);
        reverseStack(stack);
        stack.push(last);
    }

    private static int getAndDeleteLast(Stack<Integer> stack) {
        //删除并返回栈底元素
        int cur = stack.pop();
        if (stack.isEmpty()) {
            return cur;
        }
        int last = getAndDeleteLast(stack);
        stack.push(cur);
        return last;
    }


//    //需要两个递归函数  1.删除栈底的元素并返回该元素  2.逆序一个栈
//    public static int getAndDeleteLast(Stack<Integer> stack) {
//        int cur = stack.pop();
//        if (stack.isEmpty()) {
//            //表示res就是栈底元素
//            return cur;
//        }
//        //否则就递归往下找栈底元素，然后再把该元素放回
//        int last = getAndDeleteLast(stack);
//        stack.push(cur);
//        return last;
//    }
//
//    public static void reverseStack(Stack<Integer> stack) {
//        if (stack == null || stack.isEmpty()) {
//            return;
//        }
//        //1.首先得到栈底元素，并删除
//        int last = getAndDeleteLast(stack);
//        //2.然后递归
//        reverseStack(stack);
//        //3.加入该栈底元素
//        stack.push(last);
//    }
}
