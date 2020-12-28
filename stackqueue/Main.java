package com.cheng.stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author nuonuo
 * @create 2020-12-25 11:05
 */
public class Main {
    Stack<Integer> numS = new Stack<>();
    Stack<Integer> minS = new Stack<>();
    public static void main(String[] args) {
        Main m = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            String s = scan.next();
            switch (s) {
                case "push":
                    int val = scan.nextInt();
                    m.push(val);
                    break;
                case "getMin":
                    System.out.println(m.getMin());
                    break;
                case "pop":
                    System.out.println(m.pop());
                    break;
            }
        }
    }
    public void push(int val) {
        numS.push(val);
        while (!minS.isEmpty() && minS.peek() > val) {
            minS.pop();
        }
        minS.push(val);
    }
    public int pop() {
        int pop = numS.pop();
        if (pop == minS.peek()) {
            minS.pop();
        }
        return pop;
    }
    public int getMin() {
        return minS.peek();
    }
}
