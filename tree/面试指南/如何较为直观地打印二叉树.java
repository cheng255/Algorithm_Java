package com.cheng.tree.面试指南;

import com.cheng.tree.util.Node;
import com.cheng.tree.util.TreeUtils;

/**
 *
 * @author nuonuo
 * @create 2021-04-24 19:49
 */
public class 如何较为直观地打印二叉树 {

    public static void main(String[] args) {
        Node head = TreeUtils.getTree();
        printTree(head);
    }

    private static void printTree(Node head) {
        printTreeInOrder(head, 0, "H", 17);
    }

    private static void printTreeInOrder(Node head, int height, String to, int len) {
        if (head == null) return;

        printTreeInOrder(head.right, height+1, "v", len);

        String val = to + head.val + to;
        //加空格
        int lenL = (len - val.length()) / 2;
        int lenR = len - val.length() - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printTreeInOrder(head.left, height+1, "^", len);
    }

    private static String getSpace(int lenR) {
        StringBuilder sb = new StringBuilder();
        String space = " ";
        for (int i = 0; i < lenR; i++) {
            sb.append(space);
        }
        return sb.toString();
    }
}
