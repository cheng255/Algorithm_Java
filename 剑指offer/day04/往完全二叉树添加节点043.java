package day04;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 *
 * 思路：  用队列进行  层序遍历 然后插入即可  很简单  写了两个不同版本
 *
 *
 */
public class 往完全二叉树添加节点043 {
    class CBTInserter {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode head;
        public CBTInserter(TreeNode root) {
            head = root;
            queue.addLast(head);
        }

        public int insert(int v) {
            while (!queue.isEmpty()) {
                TreeNode cur = queue.pollFirst();
                if (cur.left == null) {
                    cur.left = new TreeNode(v);
                    queue.addFirst(cur);
                    return cur.val;
                }
                if (cur.right == null) {
                    cur.right = new TreeNode(v);
                    queue.addFirst(cur);
                    return cur.val;
                }
                queue.addLast(cur.left);
                queue.addLast(cur.right);
            }
            return 0;
        }

        public TreeNode get_root() {
            return head;
        }
    }
    class CBTInserter1 {
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode head;
        public CBTInserter1(TreeNode root) {
            head = root;
            queue.addLast(head);
            while (!queue.isEmpty()) {
                TreeNode cur = queue.pollFirst();
                if (cur.left == null || cur.right == null) {
                    queue.addFirst(cur);//放回去
                    if (cur.left != null) {
                        queue.addLast(cur.left);
                    }
                    break;
                }
                queue.addLast(cur.left);
                queue.addLast(cur.right);
            }
        }

        public int insert(int v) {
            TreeNode cur = queue.peekFirst();
            if (cur.left == null) {
                cur.left = new TreeNode(v);
                queue.addLast(cur.left);
            } else {
                cur.right = new TreeNode(v);
                queue.pollFirst();
                queue.addLast(cur.right);
            }
            return cur.val;
        }

        public TreeNode get_root() {
            return head;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        Deque<TreeNode> queue = new LinkedList<>();
        TreeNode head;

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
