package com.cheng.tree;

/**
 * LeetCode T105. 从前序与中序遍历序列构造二叉树
 * @author nuonuo
 * @create 2020-10-12 18:00
 */
public class preMidOrderBuildTree {
    public Node buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    /**
     * 递归思路： 根据前中序创建当前根结点，然后递归创建左右子树
     * @param preorder 前序
     * @param inorder 后序
     * @param preF 前序头
     * @param inF 中序头
     * @param inL 中序尾
     * @return
     */
    public Node buildTree(int[] preorder, int[] inorder, int preF, int inF, int inL) {
        if (inF > inL) {
            return null;
        }
        Node root = new Node(preorder[preF]);
        if (inF == inL) {
            return root;
        }
        int index = inF;// 在中序中找到当前跟结点
        while (index < inL && inorder[index] != preorder[preF]) {
            index++;
        }
        if (index > inF) { // 有左子树 （如果有的话左子树是前序的下一个元素）
            root.left = buildTree(preorder, inorder, preF + 1, inF, index - 1);
        }
        if (index < inL){ // 右子树 （右孩子 = preF + 左子树的个数）
            root.right = buildTree(preorder, inorder, preF + 1 + (index - inF), index + 1, inL);
        }
        return root;
    }
}
