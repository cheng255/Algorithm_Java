package day05;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给定一个二叉树的根节点 root ，返回其 最大路径和，即所有路径上节点值之和的最大值。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：6
 * 解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
 * 示例 2：
 * <p>
 * 输入：root = [-10,9,20,null,null,15,7]
 * 输出：42
 * 解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
 * <p>
 * <p>
 * 思路：就是深度遍历，记录当前子树的最大路径和，然后返回当前子树最大的一条路径
 * <p>
 * 想到了就可以做出来
 *
 * 注释的地方是看完题解改的更简便
 */
public class 节点之和最大的路径051 {
    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = Math.max(0, dfs(root.left));
        int r = Math.max(0, dfs(root.right));
        res = Math.max(res, root.val + l + r);
        return root.val + Math.max(l, r);
//        int l = dfs(root.left);
//        int r = dfs(root.right);
//        int maxPath = root.val;
//        if (l > 0) {
//            maxPath += l;
//        }
//        if (r > 0) {
//            maxPath += r;
//        }
//        res = Math.max(res, maxPath);
//        return root.val + (maxPath > root.val ? Math.max(l, r) : 0);
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
