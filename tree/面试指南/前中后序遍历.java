package com.cheng.tree.面试指南;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author nuonuo
 * @create 2021-04-22 20:32
 */
public class 前中后序遍历 {
    public static void main(String[] args) {
        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
        node2.left.left.right = new Node(5);
        node2.left.left.right.right = new Node(6);
        node2.left.right = new Node(7);
        node2.left.right.left = new Node(8);
        node2.left.right.left.right = new Node(9);
        preOrder(node2);
        System.out.println();
        preOrder1(node2);
        System.out.println();
        midOrder(node2);
        System.out.println();
        midOrder1(node2);
        System.out.println();
        postOrder(node2);
        System.out.println();
        postOrder3(node2);
        System.out.println();
        System.out.println(node2);
        System.out.println();
        seqOrder(node2);

    }
    /**
     * 层序遍历
     */
    public static void seqOrder(Node head) {
        if (head == null) return;
        System.out.println("seqOrder:");
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            System.out.print(head.val);
            if (head.left != null)
                queue.add(head.left);
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
    /**
     * 非递归版
     */
    public static void preOrder1(Node head) {
        System.out.println("preOrder1:");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                System.out.print(head.val);
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop().right;
            }
        }
    }
    public static void preOrder2(Node head) {
        System.out.println("preOrder2:");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            head = stack.pop();
            System.out.print(head.val);
            if (head.right != null)
                stack.push(head.right);
            if (head.left != null)
                stack.push(head.left);
        }
    }
    public static void midOrder1(Node head) {
        System.out.println("midOrder1:");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        while (head != null || !stack.isEmpty()) {
            while (head != null) {
                stack.push(head);
                head = head.left;
            }
            if (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.val);
                head = head.right;
            }
        }
    }
    //这个会把全数改变  不推荐
    public static void postOrder1(Node head) {
        System.out.println("postOrder1:");
        if (head == null) {
            return;
        }
        Node cur = head;
        Stack<Node> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                Node r = cur.right;
                if (r != null) {
                    stack.push(cur);
                    cur.right = null;
                } else {
                    System.out.print(cur.val);
                }
                cur = r;
            }
        }
    }
    //使用了两个栈
    public static void postOrder2(Node head) {
        System.out.println("postOrder2:");
        if (head == null) {
            return;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(head);
        while (!s1.isEmpty()) {
            head = s1.pop();
            s2.push(head);
            if (head.left != null)
                s1.push(head.left);
            if (head.right != null)
                s1.push(head.right);
        }
        while (!s2.isEmpty()) {
            System.out.print(s2.pop().val);
        }
    }
    public static void postOrder3(Node head) {
        System.out.println("postOrder3:");
        if (head == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node cur;
        while (!stack.isEmpty()) {
            cur = stack.peek();
            if (cur.left != null && head != cur.left && head != cur.right) {
                //表示左边还有，且不是从左右子树返回来的   先把左边的全部加入栈
                stack.push(cur.left);
            } else if (cur.right != null && head != cur.right) {
                //表示是从左子树过来的，此时应该加入右子树
                stack.push(cur.right);
            } else {
                //表示要不是叶子结点要不就是右子树过来的，总之左右子树都遍历结束
                System.out.print(stack.pop().val);
                head = cur;//把前置结点记录下来
            }
        }
    }
    /**
     * 递归版
     */
    public static void preOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        preOrder(head.left);
        preOrder(head.right);
    }
    public static void midOrder(Node head) {
        if (head == null) {
            return;
        }
        midOrder(head.left);
        System.out.print(head.val);
        midOrder(head.right);
    }
    public static void postOrder(Node head) {
        if (head == null) {
            return;
        }
        postOrder(head.left);
        postOrder(head.right);
        System.out.print(head.val);
    }

    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
