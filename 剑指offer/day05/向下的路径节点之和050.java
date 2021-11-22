package day05;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

/**
 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

 示例 1：

 输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
 输出：3
 解释：和等于 8 的路径有 3 条，如图所示。

 思路： 两种方法：  1.以每个节点为首，往下找。   2.记录前缀和      2方法更好一点，但我没想到，是题解看了才懂

            需要target的时候往往可以前缀和    ！！！！
 */
public class 向下的路径节点之和050 {

    public int pathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, map, 0, targetSum);
    }
    public int dfs(TreeNode root, HashMap<Long, Integer> map, long cur, int targetSum) {
        if (root == null) {
            return 0;
        }

        int res = 0;
        cur += root.val;
        res += map.getOrDefault(cur - targetSum, 0);

        map.put(cur, map.getOrDefault(cur, 0) + 1);
        res += dfs(root.left, map, cur, targetSum);
        res += dfs(root.right, map, cur, targetSum);
        map.put(cur, map.getOrDefault(cur, 0) - 1);
        return res;
    }

    public int pathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.pollFirst();
            res += func(cur, targetSum);
            if (cur.left != null) {
                queue.addLast(cur.left);
            }
            if (cur.right != null) {
                queue.addLast(cur.right);
            }
        }
        return res;
    }

    public int func(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        if (targetSum == root.val) {
            res += 1;
        }
        res += func(root.left, targetSum - root.val);
        res += func(root.right, targetSum - root.val);
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
