package com.cheng.tree.面试指南;

import com.cheng.tree.util.Node;
import com.cheng.tree.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nuonuo
 * @create 2021-04-25 21:48
 */
public class 二叉树的序列化和反序列化 {
    public static void main(String[] args) {
        Node head = TreeUtils.getTree();
        String s = serialized(head);
        String s1 = serialized1(head);
        System.out.println("前序：" + s);
        System.out.println("层序：" + s1);
        Node node = deSerialized(s);
        Node node1 = deSerialized1(s1);
        System.out.println(node);
        System.out.println(node1);
    }
    private static Node deSerialized1(String s) {
        if (s.equals("#!")) {
            return null;
        }

        String[] split = s.split("!");
        Queue<Node> queue = new LinkedList<>();
        Node node = new Node(Integer.parseInt(split[0]));
        queue.offer(node);
        int i = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (!split[i].equals("#")) {//左不是空值
                poll.left = new Node(Integer.parseInt(split[i]));
                queue.add(poll.left);
            }
            i++;
            if (!split[i].equals("#")) {//右不是空值
                poll.right = new Node(Integer.parseInt(split[i]));
                queue.add(poll.right);
            }
            i++;
        }
        return node;
    }


    private static String serialized1(Node head) {
        if (head == null) {
            return "#!";
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(head);
        StringBuilder res = new StringBuilder(head.val + "!");
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            if (poll.left == null) {
                res.append("#!");
            } else {
                res.append(poll.left.val).append("!");
                queue.offer(poll.left);
            }
            if (poll.right == null) {
                res.append("#!");
            } else {
                res.append(poll.right.val).append("!");
                queue.offer(poll.right);
            }
        }
        return res.toString();
    }

    private static Node deSerialized(String s) {
        if (s == "#!") {
            return null;
        }
        String[] split = s.split("!");
        Queue<String> queue = new LinkedList<>();
        for (String value : split) {
            queue.offer(value);
        }
        return doThis(queue);
    }

    private static Node doThis(Queue<String> queue) {
        String poll = queue.poll();
        if (poll == null || poll.equals("#")) {
            return null;
        }
        Node node = new Node(Integer.parseInt(poll));
        node.left = doThis(queue);
        node.right = doThis(queue);
        return node;
    }

    private static String serialized(Node head) {
        if (head == null) {
            return "#!";
        }
        String s = head.val + "!";
        s += serialized(head.left);
        s += serialized(head.right);
        return s;
    }


}
