package com.cheng.tree;

import java.util.LinkedList;
import java.util.List;

/**
 *  LeetCode T95. 不同的二叉搜索树 II
 * 给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
 * 输入：3
 * 输出：
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 *
 * @author nuonuo
 * @create 2020-11-13 13:53
 */


public class DifferentBST2 {
    public List<TreeNode> generateTrees(int n) {
        //思路，将当前位置作为根节点  枚举所有左子树的结构可能 作为集合A 右子树作为集合B
        //从左右子树各选一项和根节点连接组成答案
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generateTrees(1, n);
    }

    private List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> nodes = new LinkedList<>();//结果集合由慢慢迭代而来！！！
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            //枚举每一个结点作为根的情况
            List<TreeNode> lefts = generateTrees(start, i - 1);//得到左子树结构集合
            List<TreeNode> rights = generateTrees(i + 1, end);//得到右子树结构集合

            for (TreeNode l : lefts) {
                for (TreeNode r : rights) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    nodes.add(cur);
                }
            }

        }
        return nodes;
    }
}

class TreeNode {
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
