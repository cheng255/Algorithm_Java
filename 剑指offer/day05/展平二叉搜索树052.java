package day05;

/**
 * 给你一棵二叉搜索树，请 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 * 输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 * <p>
 * 思路： 中序遍历，然后记录上一个遍历到的结点，    这道题我看题解才做出来！！！
 *                                          虚拟头节点往往可以简化题！！！！下次继续做
 */
public class 展平二叉搜索树052 {
    TreeNode pre;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode temp = new TreeNode(-1);//虚拟头节点
        pre = temp;
        dfs(root);
        return temp.right;
    }

    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        dfs(cur.left);

        pre.right = cur;
        cur.left = null;
        pre = cur;

        dfs(cur.right);

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
