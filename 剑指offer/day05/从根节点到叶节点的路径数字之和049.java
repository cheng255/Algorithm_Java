package day05;

/**
 * 给定一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 * 叶节点 是指没有子节点的节点。
 * 示例 1：
 * 输入：root = [1,2,3]
 * 输出：25
 * 解释：
 * 从根到叶子节点路径 1->2 代表数字 12
 * 从根到叶子节点路径 1->3 代表数字 13
 * 因此，数字总和 = 12 + 13 = 25
 *
 * 思路：  我是dfs做的    题解写的更完成  2方法    就是左右子树的和加起来
 *
 *
 * 注意递归函数的写法
 */
public class 从根节点到叶节点的路径数字之和049 {
    public int sumNumbers2(TreeNode root) {
        return dfs1(root, 0);
    }
    public int dfs1(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;//叶子结点
        } else {
            return dfs1(root.left, sum) + dfs1(root.right, sum);
        }
    }
    int res = 0;
    public int sumNumbers1(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public void dfs(TreeNode root, int sum) {
        sum = sum * 10 + root.val;
        if (root.left == null && root.right == null) {
            res += sum;//叶子结点
        } else {
            if (root.left != null) {
                dfs(root.left, sum);
            }
            if (root.right != null) {
                dfs(root.right, sum);
            }
        }
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
