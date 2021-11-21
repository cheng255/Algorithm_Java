package day05;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * 示例1：
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * /  \
 * 3    2
 * /  \    \
 * 5    3    9
 *
 * 思路：  层序遍历  用队列   一层一层遍历就行
 *  我的思路1： 记录当前层的数量        看了题解2：发现不用记录 size()就是
 *      还有个方法虽然速度不快：创建一个辅助类 拥有层级的成员变量
 */
public class 二叉树每层的最大值044 {
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            int sum = queue.size();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < sum; i++) {//把这一层遍历完
                cur = queue.pollFirst();
                if (cur.val > max) max = cur.val;//该层最大值替换
                if (cur.left != null) {
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    queue.addLast(cur.right);
                }
            }
            res.add(max);//该层最大值拿到
        }
        return res;
    }
    public List<Integer> largestValues1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        TreeNode cur;
        int sum = 1;//记录每层的总数，初始第一层为1
        while (sum > 0) {
            int temp = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < sum; i++) {//把这一层遍历完
                cur = queue.pollFirst();
                if (cur.val > max) max = cur.val;//该层最大值替换
                if (cur.left != null) {
                    temp++;
                    queue.addLast(cur.left);
                }
                if (cur.right != null) {
                    temp++;
                    queue.addLast(cur.right);
                }
            }
            res.add(max);//该层最大值拿到
            sum = temp;//下一层的数量
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
