package day06;

import java.util.HashSet;

/**
 * 给定一个二叉搜索树的 根节点 root 和一个整数 k , 请判断该二叉搜索树中是否存在两个节点它们的值之和等于 k 。假设二叉搜索树中节点的值均唯一。
 * 示例 1：
 * 输入: root = [8,6,10,5,7,9,11], k = 12
 * 输出: true
 * 解释: 节点 5 和节点 7 之和等于 12
 * 示例 2：
 * 输入: root = [8,6,10,5,7,9,11], k = 22
 * 输出: false
 * 解释: 不存在两个节点值之和为 22 的节点
 *
 * 思路：很简单，就遍历 + hash表    参考两数之和问题
 */
public class 二叉搜索树中两个节点之和056 {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map = new HashSet<>();
        return dfs(root, map, k);
    }

    public boolean dfs(TreeNode root, HashSet<Integer> map, int k) {
        if (root == null) return false;

        if (map.contains(root.val)) {
            return true;
        }
        map.add(k - root.val);
        return dfs(root.left, map, k) || dfs(root.right, map, k);

    }

    public class TreeNode {
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
