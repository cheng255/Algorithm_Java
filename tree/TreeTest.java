package com.cheng.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 树的前序中序后序遍历和层序遍历
 * @author 86182
 *
 */
public class TreeTest {
	 
    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
 
        public TreeNode(int data) {
            this.data = data;
        }
    }
 
    /**
     * 构建二叉树
     * 注意这里构建的顺序和前序遍历的顺序相同
     * @param inputList
     * @return
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
 
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
 
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
 
        return node;
    }
 
    /**
     * 二叉树的层序遍历
     * @param root
     */
    public static void levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
 
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }
 
    /**
     * 二叉树的前序遍历递归实现
     * @param node
     */
    public static void preOrderTraveralByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
 
        System.out.println(node.data);
        preOrderTraveralByRecursion(node.leftChild);
        preOrderTraveralByRecursion(node.rightChild);
    }
 
    /**
     * 二叉树的前序遍历栈实现
     * @param root
     */
    public static void preOrderTraveralByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
 
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                System.out.println(node.data);
                node = node.leftChild;
            }
 
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.rightChild;
            }
        }
    }
 
    /**
     * 二叉树的中序遍历递归实现
     * @param node
     */
    public static void inOrderTraveralByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
 
        inOrderTraveralByRecursion(node.leftChild);
        System.out.println(node.data);
        inOrderTraveralByRecursion(node.rightChild);
    }
 
    /**
     * 二叉树的中序遍历栈实现
     * @param root
     */
    public static void inOrderTraveralByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
 
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
 
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.data);
                node = node.rightChild;
            }
        }
    }
 
    /**
     * 二叉树的后序遍历递归实现
     * @param node
     */
    public static void postOrderTraveralByRecursion(TreeNode node) {
        if (node == null) {
            return;
        }
 
        postOrderTraveralByRecursion(node.leftChild);
        postOrderTraveralByRecursion(node.rightChild);
        System.out.println(node.data);
    }
 
    /**
     * 二叉树的后序遍历栈实现
     * @param root
     */
    public static void postOrderTraveralByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        TreeNode tempNode = null;
 
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.leftChild;
            }
 
            if (!stack.isEmpty()) {
                node = stack.pop();
                tempNode = node.rightChild;
                if (tempNode != null) {
                    node.rightChild = null;
                    stack.push(node);
                } else {
                    System.out.println(node.data);
                }
                node = tempNode;
            }
        }
    }
 
    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4));
        
    }
}
