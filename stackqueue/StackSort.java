package com.cheng.stackqueue;

import java.util.Stack;

/**
 * 用一个栈实现对另一个栈的排序
 * @author nuonuo
 * @create 2020-12-18 12:19
 */
public class StackSort {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(5);
        stack.push(6);
        stack.push(2);
        stackSort(stack);
        System.out.println(stack);
    }
    //思路: 创建的栈为sortStack  之前的叫perStack   从perStack往sortStack加入元素，当前元素要确保比
    //          栈中元素都大，不然就将sortStack中元素倒回去   此操作直到perStack中没有元素
    private static void stackSort(Stack<Integer> perStack) {
        Stack<Integer> sortStack = new Stack<>();
        while (!perStack.isEmpty()) {
            int cur = perStack.pop();
            while (!sortStack.isEmpty() && sortStack.peek() > cur) {
                perStack.push(sortStack.pop());
            }
            sortStack.push(cur);
        }
        while (!sortStack.isEmpty()) {
            perStack.push(sortStack.pop());
        }
    }

}
