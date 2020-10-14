package com.cheng.tree;

import java.util.Stack;

/**
 * LeetCode T897. 递增顺序查找树
 * 给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，
 * 并且每个结点没有左子结点，只有一个右子结点。
 * 输入：[5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * 输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 * @author nuonuo
 * @create 2020-10-14 17:11
 */
//主要思路就是中序遍历   注意代码细节
public class searchTreeIncreasingOrder {
    public Node increasingBST(Node root) {
        if (root == null) {
            return null;
        }
        Stack<Node> stack = new Stack<>();
        Node cur = root;
        Node pre = null;//表示cur前被遍历到的结点
        Node first = null;
        boolean flag = true;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //第一次需要特殊处理
            //将最左的结点记录下来
            if (flag) {
                first = stack.pop();

                pre = first;
                cur = pre.right;
                flag = false;
                continue;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                pre.right = cur;
                pre.left = null; // 注意

                pre = cur;
                cur = cur.right;
            }
        }
        return first;

    }

}
