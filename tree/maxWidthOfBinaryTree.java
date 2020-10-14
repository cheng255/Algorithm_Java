package com.cheng.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * LeetCode T662:二叉树最大宽度
 * @author nuonuo
 * @create 2020-10-14 16:54
 *
 * 输入:
 *
 *            1
 *          /   \
 *         3     2
 *        / \     \
 *       5   3     9
 *
 * 输出: 4
 * 解释: 最大值出现在树的第 3 层，宽度为 4 (5,3,null,9)。
 */
class NodeT {
    Node node;//结点
    int floor;//层号
    int pasition;//序号

    public NodeT(Node root, int floor, int pasition) {
        node = root;
        this.floor = floor;
        this.pasition = pasition;
    }
}
//思路:需要记录每个节点所在的层和每个节点的编号，封装成一个类然后层序遍历
public class maxWidthOfBinaryTree {
    public static int widthOfBinaryTree(Node root) {
        // 思路： 在层序遍历的基础上加上当前的层号，然后记录每一层的节点个数
        if (root == null) {
            return 0;
        }
        int[] res = new int[100000]; //记录每一层的宽度
        Queue<NodeT> queue = new LinkedList<>();
        NodeT rootT = new NodeT(root, 0, 1);
        queue.offer(rootT);
        int max = 0; // 记录最大的宽度
        int temp = 0;//表示当前的层极
        res[temp] = 1;//第0层为1
        NodeT first = rootT;
        while (!queue.isEmpty()) {
            NodeT cur = queue.poll();
            if (cur.floor == temp) {//同一层
                res[temp] = cur.pasition - first.pasition + 1;
            } else {
                res[++temp] = 1;//temp层级加一
                first = cur; // 记录该层第一个结点
            }
            if (res[temp] > max) {
                max = res[temp];
            }
            if (cur.node.left != null) {
                queue.offer(new NodeT(cur.node.left, cur.floor + 1, cur.pasition<<1));
            }
            if (cur.node.right != null) {
                queue.offer(new NodeT(cur.node.right, cur.floor + 1, (cur.pasition<<1) + 1));
            }
        }
        return max;
    }
}
