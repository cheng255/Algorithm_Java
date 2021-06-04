package com.cheng.dfs;

import java.util.Stack;

/**
 * LeetCode 114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 * @author nuonuo
 * @create 2021-06-04 21:25
 */
public class 二叉树展开为链表 {
    /**
     * O（1）空间复杂度的方法
     * @param root
     */
    public void flatten2(TreeNode root) {
        if (root == null) return;
        TreeNode cur = root;
        TreeNode leftMostRight = null;
        while (cur != null) {
            //如果当前结点的左子树不为空的话
            //下一个遍历的是左子树，然后要遍历的是右子树，所以要找到左子树中最右的结点，作为右子树的前置结点

            if (cur.left != null) {
                leftMostRight = cur.left;
                while (leftMostRight.right != null) {
                    leftMostRight = leftMostRight.right;
                }
                leftMostRight.right = cur.right;//这个节点遍历完就是当前结点的右子树
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
    public void flatten1(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        stack.push(cur);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);

            }
            if (pre != null) {
                pre.right = cur;
                pre.left = null;
            }
            pre = cur;

        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
