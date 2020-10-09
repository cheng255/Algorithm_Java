package com.cheng.tree;

import java.util.*;

/**
 * 二叉树的一些经典面试题
 *
 * @author nuonuo
 * @create 2020-10-09 19:51
 */
public class someProblem {
    public static void main(String[] args) {
        Node node2 = new Node(1);
        node2.left = new Node(2);
        node2.right = new Node(3);
        node2.left.left = new Node(4);
//        node2.left.left.left = new Node(4);
//        System.out.println(completeBinaryTree(node2));
//        printLeverAndNode(node2);
        List<List<lNode>> lists = leverOrder(node2);
        Iterator<List<lNode>> it = lists.iterator();
        while (it.hasNext()) {
            Iterator<lNode> it1 = it.next().iterator();
            while (it1.hasNext()) {
                System.out.print(it1.next() + " ");
            }
            System.out.println();
        }

    }

    /**
     * 输入一个前序遍历的二叉树序列 ，用中序遍历输出  null 用 # 表示
     * 思路： 递归思想： 用in前序序列构建当前结点，并把剩余的结点放入out,并根据out构建当前结点的左右子树
     *
     * @param in                 : 传进来的前序序列
     * @param out：构建完当前结点剩下的前序序列
     * @return 构建好的当前结点
     */
    public static Node preToPost(List<Character> in, List<Character> out) {
        if (in.isEmpty()) { // 用于构建当前结点的序列为空
            return null;
        }
        char rootKey = in.remove(0);
        // 如果需要构造的结点是null
        if (rootKey =='#'){
            out.addAll(in); //剩余的序列
            return null;
        }
        Node root = new Node(rootKey); // 构建当前结点
        List<Character> rightOut = new ArrayList<>();
        Node left = preToPost(in, rightOut); // 构建左子树 并且将剩下的序列放在rightOut中
        // 剩下的都是用于构建右子树的序列
        Node right = preToPost(rightOut, out);

        root.left = left;
        root.right = right;

        // 至此二叉树建成
        //中序遍历省略
        return root;
    }

    /**
     * 判断一颗树是不是完全二叉树
     * 思路：1.用层序顺序将节点加入队列 （无论是否为null）
     * 2.当取到的cur节点 == null时， 此时判断队列中剩余的节点
     * if 全为null return true
     * else   return false
     */
    public static boolean completeBinaryTree(Node root) {
        if (root == null) {
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                break;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        while (!queue.isEmpty()) {
            if (queue.poll() != null) {
                return false;
            }
        }
        return true;

    }

    /**
     * 对一颗二叉树层序遍历，输出值的同时，输出她的层数
     * <p>
     * 思路：队列里不仅放节点也放层数   层数孩子节点+1即可
     * // 可以将节点和层数打包成一个类
     */

    public static void printLeverAndNode(Node root) {
        if (root == null) {
            return;
        }
        Queue<lNode> queue = new LinkedList<>();
        queue.offer(new lNode(root, 1));
        while (!queue.isEmpty()) {
            lNode cur = queue.poll();
            System.out.println(cur);
            if (cur.node.left != null) {
                queue.offer(new lNode(cur.node.left, cur.lever + 1));
            }
            if (cur.node.right != null) {
                queue.offer(new lNode(cur.node.right, cur.lever + 1));
            }
        }
    }

    /**
     * 按层打印二叉树
     */
    public static List<List<lNode>> leverOrder(Node root) {
        if (root == null) {
            return null;
        }
        List<List<lNode>> list = new ArrayList<>();
        Queue<lNode> queue = new LinkedList<>();
        queue.offer(new lNode(root, 0));
        List<lNode> curList = null;
        while (!queue.isEmpty()) {
            lNode cur = queue.poll();
            if (list.size() == cur.lever) { // 需要新建list
                curList = new ArrayList<>();
                list.add(curList);
            }
            curList.add(cur);
            if (cur.node.left != null) {
                queue.offer(new lNode(cur.node.left, cur.lever + 1));
            }
            if (cur.node.right != null) {
                queue.offer(new lNode(cur.node.right, cur.lever + 1));
            }
        }
        return list;
    }

    static class lNode {
        Node node;
        int lever;

        public lNode(Node node, int lever) {
            this.node = node;
            this.lever = lever;
        }

        @Override
        public String toString() {
            return "lNode{" +
                    "node=" + node +
                    ", lever=" + lever +
                    '}';
        }
    }
}