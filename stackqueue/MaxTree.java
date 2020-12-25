package com.cheng.stackqueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 构造数组的 MaxTree  O(N)  O(N)   无重复
 * @author nuonuo
 * @create 2020-12-22 16:31
 */
class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}

public class MaxTree {
    public static void main(String[] args) {
        Node maxTree = createMaxTree(new int[]{3, 4, 5, 1, 2});
        seqOrder(maxTree);
    }
    private static Node createMaxTree(int[] arr) {
        //核心思想：
        //1.每一个数的父结点是他左边第一个比他大的数字和右边第一个比他大的数字中较小的那个
        //2.如果这个数左右都没有比他大的数字，那么他就是整棵树的父结点
        //3.如何找到左右两边第一个比他大的数字
            //3.1 使用栈，来记录一个递减序列
            //3.2 当前数比栈顶元素小时，当前栈顶元素就是第一个左边比他大的数
            //3.3 当前数比栈顶元素大时，栈顶元素需要pop 且当前数就是栈顶元素的右边的第一个最大的数
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Node cur = new Node(arr[i]);
            map.put(arr[i], cur);
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                // 3.3
                Node node = map.get(stack.pop());//栈顶元素取出后，此时栈顶为他左边第一个比他大的数
                //确定node的父结点   左右两者中较小的那个
                Node per = cur;
                if (!stack.isEmpty() && stack.peek() < cur.value) {
                    per = map.get(stack.peek());
                }
                if (per.left == null) {
                    per.left = node;
                } else {
                    per.right = node;
                }

            }
            stack.push(arr[i]);
        }
        //比如3 4 5 1 2经过这些操作  栈中只剩下 5 2  这样的递减序列，栈底为树的头节点，其他的数的父结点都是他下面的元素
        Node node = map.get(stack.pop());
        while (!stack.isEmpty()) {
            Node per = map.get(stack.pop());
            if (per.left == null) {
                per.left = node;
            } else {
                per.right = node;
            }
            node = per;
        }
        return node;
    }
    private static void seqOrder(Node head) {
        if (head == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            System.out.print(cur.value + " ");
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }
}
