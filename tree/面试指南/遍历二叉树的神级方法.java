package com.cheng.tree.面试指南;

import com.cheng.tree.util.Node;
import com.cheng.tree.util.TreeUtils;

/**
 * morris算法   用叶子结点的left和right指针来达到从底到高（栈）的效果
 * 空间复杂度O(1)  时间复杂度 O(N)
 * @author nuonuo
 * @create 2021-04-26 21:46
 */
public class 遍历二叉树的神级方法 {
    public static void main(String[] args) {
        Node head = TreeUtils.getTree();
        morrisMidOrder(head);
        System.out.println();
        morrisProOrder(head);
    }
    //前序   不同的是将左树的最右的结点的right域指向右树
    private static void morrisProOrder(Node head) {
        if (head == null) return;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            System.out.print(cur1.val + " ");
            cur2 = cur1.left;
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1.right) {
                    cur2 = cur2.right;
                }
                if (cur2.right == null) {
                    cur2.right = cur1.right;
                    cur1 = cur1.left;
                    continue;
                } else {
                    cur2.right = null;
                }
            }
            cur1 = cur1.right;
        }
    }

    //中序
    private static void morrisMidOrder(Node head) {
        if (head == null) return;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null) {
            cur2 = cur1.left;
            //首先找到当前结点的左子树的最右节点,前提是左子树不为空
            if (cur2 != null) {
                while (cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if (cur2.right == cur1) { //表示左子树已经遍历完
                    cur2.right = null;
                } else {//找到这个元素后，将right指向当前结点，然后再同样的方式去找当前结点的left
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }
            }
            //左子树为空就可以通过right域打印了
            System.out.print(cur1.val + " ");
            cur1 = cur1.right;
        }
    }
}
