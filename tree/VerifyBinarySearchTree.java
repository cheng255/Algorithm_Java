package com.cheng.tree;

import java.util.Stack;

/**
 * 98. 验证二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * @author nuonuo
 * @create 2020-11-14 13:13
 */
public class VerifyBinarySearchTree {

    //思路 每个节点的值都有一个范围
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    /**
     * 方法一：递归
     *  表示以root为根节点的子树都要满足（less,more）
     */
    private boolean helper(TreeNode root, Integer less, Integer more) {
        if (root == null) {//当前结点为空
            return true;
        }
        //1.判断当前结点是否满足（less,more）
        if (less != null && root.val <= less) {
            return false;
        }
        if (more != null && root.val >= more) {
            return false;
        }
        //2.如果满足，判断他的左右子树
        return helper(root.right,root.val,more) && helper(root.left,less,root.val);
    }

    /**
     * 方法二：中序遍历，因为二叉搜索树的中序遍历是有序的
     *
     */
    private boolean helper2(TreeNode root) {
        if (root == null) {//当前结点为空
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;//前一个节点
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                if (pre != null && pre.val >= cur.val) {
                    return false;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return true;
    }
    public static void main(String[] args) {


    }

}
