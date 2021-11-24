package day05;

/**
 * 给定一棵二叉搜索树和其中的一个节点 p ，找到该节点在树中的中序后继。如果节点没有中序后继，请返回 null 。
 * 节点 p 的后继是值比 p.val 大的节点中键值最小的节点，即按中序遍历的顺序节点 p 的下一个节点。
 * 示例 1：
 * 输入：root = [2,1,3], p = 1
 * 输出：2
 * 解释：这里 1 的中序后继是 2。请注意 p 和返回值都应是 TreeNode 类型。
 * 示例 2：
 * 输入：root = [5,3,6,2,4,null,null,1], p = 6
 * 输出：null
 * 解释：因为给出的节点没有中序后继，所以答案就返回 null 了。
 * <p>
 * <p>
 * 思路：   1、中序遍历，然后记录一个pre和cur结点就行了
 * 2.因为是二叉搜索树，所以可以直接二分  找到刚好比p大的那一个   ！！这个更牛
 */
public class 二叉搜索树中的中序后继053 {

    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode cur = root;
        TreeNode r = null;
        while (cur != null) {
            if (cur.val > p.val) {
                r = cur;
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return r;
    }


    TreeNode pre = null;
    TreeNode res = null;

    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        dfs(root, p);
        return res;
    }

    public void dfs(TreeNode root, TreeNode p) {
        if (root == null) {
            return;
        }
        dfs(root.left, p);
        if (pre != null && res == null) {//目标节点的后继  只记录一次
            res = root;
            return;
        }
        if (root == p) {//记录目标节点
            pre = p;
        }
        dfs(root.right, p);
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
