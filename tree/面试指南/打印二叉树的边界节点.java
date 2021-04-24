package com.cheng.tree.面试指南;

import com.cheng.tree.util.Node;
import com.cheng.tree.util.TreeUtils;

import java.util.Stack;

/**
 * 分别按照两个标准来逆时针打印二叉树的边界节点
 * <p>
 * 标准1：头节点，叶子结点，每层最外面的结点
 * 标准2：头节点，叶子结点，左边界延续下去的结点，右边界延续下去的结点
 * <p>
 * 要求：时间复杂度 O(N)   空间复杂度 O(h)
 *
 * @author nuonuo
 * @create 2021-04-23 16:15
 */
public class 打印二叉树的边界节点 {
    public static void main(String[] args) {
        Node head = TreeUtils.getTree();
        printBoundaryNodes1(head);
    }

    public static void printBoundaryNodes1(Node head) {
        //每层只记录2个结点  最左和最右
        System.out.print(head.val + " ");
        Node l = head.left;
        Node r = head.right;
        //先打印左边界,//叶子结点先不打印
        while (l != null && (l.left != null || l.right != null)) {
            System.out.print(l.val + " ");
            l = l.left != null ? l.left : l.right;
        }
        //打印叶子结点
        printLeafNodes(head);
        //再倒着打印右边界,//叶子结点不打印
        Stack<Node> stack = new Stack<>();
        while (r != null && (r.left != null || r.right != null)) {
            stack.push(r);
            r = r.right != null ? r.right : r.left;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().val + " ");
        }

    }

    private static void printLeafNodes(Node head) {
        if (head.left == null && head.right == null) {
            System.out.print(head.val + " ");
            return;
        }
        if (head.left != null)
            printLeafNodes(head.left);
        if (head.right != null)
            printLeafNodes(head.right);
    }

}
