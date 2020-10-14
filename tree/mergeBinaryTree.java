package com.cheng.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode T617. 合并二叉树
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 *
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
 * 否则不为 NULL 的节点将直接作为新二叉树的节点。
 * 输入:
 * 	Tree 1                     Tree 2
 *           1                         2
 *          / \                       / \
 *         3   2                     1   3
 *        /                           \   \
 *       5                             4   7
 * 输出:
 * 合并后的树:
 * 	     3
 * 	    / \
 * 	   4   5
 * 	  / \   \
 * 	 5   4   7
 *
 * 	 主要思路 是层序遍历
 * @author nuonuo
 * @create 2020-10-14 20:22
 */
public class mergeBinaryTree {
    public static void main(String[] args) {

    }
    public Node mergeTrees(Node t1, Node t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        Node cur1 = t1;
        Node cur2 = t2;
        Queue<Node> queue1 = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue1.offer(cur1);
        queue2.offer(cur2);
        while (!(queue1.isEmpty() || queue2.isEmpty())) {
            cur1 = queue1.poll();
            cur2 = queue2.poll();
            cur1.val = cur1.val + cur2.val;
            if (cur1.left != null && cur2.left != null) {
                //cur1 cur2 都有左子树
                queue1.offer(cur1.left);
                queue2.offer(cur2.left);
            } else if (cur2.left != null) {
                //只有cur2有左子树 将cur2的left连在cur1下
                cur1.left = cur2.left;
            }
            //只有cur1有左子树 或都没有 -》不用操作
            if (cur1.right != null && cur2.right != null) {
                //cur1 cur2 都有右子树
                queue1.offer(cur1.right);
                queue2.offer(cur2.right);
            } else if (cur2.right != null) {
                //只有cur2有左子树 将cur2的left连在cur1下
                cur1.right = cur2.right;
            }

        }
        return t1;
    }
}
