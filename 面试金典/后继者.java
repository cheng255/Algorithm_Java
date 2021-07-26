package com.cheng.面试金典;

import java.util.Stack;

/**
 * @author nuonuo
 * @create 2021-07-26 9:12
 */
public class 后继者 {

    //方法1：    循环
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode pre = null;
        while (root != null) {
            if (root.val == p.val) {
                //找到了这个节点 , 就去找这个结点的下一个
                if (root.right == null) {
                    return pre;
                } else {//如果右树不为空，就找右树上最左的结点
                    root = root.right;
                    while (root.left != null) {
                        root = root.left;
                    }
                    return root;
                }
            } else if (root.val < p.val) {
                // pre = root;//右子树的父结点不记录
                root = root.right;
            } else {//左边
                pre = root;
                root = root.left;
            }

        }
        return null;
    }

    //方法2    中序遍历
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack<>();
        boolean flag = false;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                if (flag) {
                    //上一个结点是P
                    return root;
                }
                if (root.val == p.val) {
                    flag = true;
                }
                root = root.right;

            }
        }
        return null;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
