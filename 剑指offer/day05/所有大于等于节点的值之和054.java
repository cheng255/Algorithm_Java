package day05;

import java.util.Stack;

/**
 * 给定一个二叉搜索树，请将它的每个节点的值替换成树中大于或者等于该节点值的所有节点值之和。
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * <p>
 * 输入：root = [4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
 * 输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 * <p>
 * 思路：  就是   右 -> 中 -> 左  就行了
 *
 *  写了递归和非递归的
 */
public class 所有大于等于节点的值之和054 {
    public TreeNode convertBST2(TreeNode root) {
        //完成遍历    右->中->左即可
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();

                sum += cur.val;
                cur.val = sum;

                cur = cur.left;
            }

        }
        return root;
    }


    int sum = 0;

    public TreeNode convertBST1(TreeNode root) {
        //完成遍历    右->中->左即可
        dfs(root);
        return root;
    }

    public void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.right);

        sum += root.val;
        root.val = sum;

        dfs(root.left);

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
