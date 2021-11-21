package day05;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 输入: [1,2,3,null,5,null,4]
 输出: [1,3,4]
 示例 2:
 输入: [1,null,3]
 输出: [1,3]
 示例 3:
 输入: []
 输出: []

 思路：和上一题一样，只是保存的是每层最后一个值
 */
public class 二叉树的右侧视图046 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                cur = queue.pollFirst();
                if (size == 1) {
                    //保存最后一个
                    res.add(cur.val);
                }
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
                size--;
            }
        }
        return res;
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
