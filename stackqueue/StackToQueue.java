package com.cheng.stackqueue;

import java.util.Stack;

/**
 * T:由两个栈组成的队列
 *
 * @author nuonuo
 * @create 2020-12-16 13:59
 */
public class StackToQueue {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;
    public StackToQueue() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.add(1);
        stackToQueue.add(2);
        stackToQueue.add(3);
        stackToQueue.add(4);
        stackToQueue.add(5);
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());
        System.out.println(stackToQueue.poll());
    }

    //加入直接往stackPush里加入
    public void add(int val) {
        stackPush.push(val);
    }

    //取出需要用到stackPop
    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        if (!stackPop.isEmpty()) {
            return stackPop.pop();
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.pop());
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("the queue is empty");
        }
        if (!stackPop.isEmpty()) {
            return stackPop.peek();
        }
        while (!stackPush.isEmpty()) {
            stackPop.push(stackPush.peek());
        }
        return stackPop.peek();
    }
}
