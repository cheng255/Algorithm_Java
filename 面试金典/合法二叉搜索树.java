package com.cheng.面试金典;

import java.util.Stack;

/**
 * 两种方法，，，，，1.  中序遍历                2。   递归
 * @author nuonuo
 * @create 2021-07-25 20:17
 */
public class 合法二叉搜索树 {

     private static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

        public boolean isValidBST(TreeNode root) {
            return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
        }

        //就是说 如果左子树不为空，必须全部小于跟结点，右子树必须全部大于跟结点
//给当前结点的值一个范围
        public boolean helper(TreeNode root, long more, long less) {
            if (root == null) {
                return true;
            }
            if (root.val >= more || root.val <= less) {
                //如果当前结点不满足要求，就返回false
                return false;
            }
            //当前结点满足条件
            return helper(root.left, root.val, less) && helper(root.right, more, root.val);
        }
         public boolean isValidBST1(TreeNode root) {
             //中序遍历是有序的
             Stack<TreeNode> stack = new Stack<>();
             double front = -Double.MAX_VALUE;
             while (root != null || !stack.isEmpty()) {

                 while (root != null) {
                     stack.push(root);
                     root = root.left;
                 }

                 if (!stack.isEmpty()) {
                     root = stack.pop();
                     if (root.val <= front) {
                         return false;//不是有序的了
                     }
                     front = root.val;
                     root = root.right;
                 }
             }
             return true;
         }
}
