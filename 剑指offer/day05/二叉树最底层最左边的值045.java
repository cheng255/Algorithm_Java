package day05;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * 示例 1:
 * 输入: root = [2,1,3]
 * 输出: 1
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 *
 *
 * 思路：和上一题一样，只是保存每层第一个 而不是最大的
 */
public class 二叉树最底层最左边的值045 {

    public int findBottomLeftValue(TreeNode root) {
        int res = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.pollFirst();
                if (i == 0) res = cur.val;//当前层第一个

                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
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
