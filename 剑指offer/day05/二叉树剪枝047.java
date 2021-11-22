package day05;

/**
 * 给定一个二叉树 根节点 root ，树的每个节点的值要么是 0，要么是 1。请剪除该二叉树中所有节点的值为 0 的子树。
 * <p>
 * 节点 node 的子树为 node 本身，以及所有 node 的后代。
 * 示例 1:
 * <p>
 * 输入: [1,null,0,0,1]
 * 输出: [1,null,0,null,1]
 * 解释:
 * 只有红色节点满足条件“所有不包含 1 的子树”。
 * 右图为返回的答案。
 *
 *
 * 思路：  1.我的思路：计算子树的sum并且裁断        其实就是二叉树后序遍历
 *
 *     2.题解版本
 *
 */
public class 二叉树剪枝047 {
    public TreeNode pruneTree2(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.left = pruneTree2(root.left);
        root.right = pruneTree2(root.right);
        if (root.val == 0 && root.left == null && root.right == null) {
            root = null;
        }
        return root;
    }
    public TreeNode pruneTree1(TreeNode root) {
        if (func(root) == 0) {
            return null;
        }
        return root;
    }

    public int func(TreeNode cur) {
        if (cur == null) {
            return 0;
        }
        int leftSum = func(cur.left);
        if (leftSum == 0) {
            cur.left = null;
        }
        int rightSum = func(cur.right);
        if (rightSum == 0) {
            cur.right = null;
        }
        return leftSum + rightSum + cur.val;
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
