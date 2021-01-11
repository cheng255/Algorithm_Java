package com.cheng.linkedList;

/**
 * 环形单链表的约瑟夫问题
 * <p>
 * 原问题：
 * 输入：一个环形单向链表的头节点head 和报数的值m
 * 返回：最后生存下来的结点，且这个节点自己组成环形单向链表，其他节点都删掉
 * 进阶：
 * 如果链表节点数为N， 想在时间复杂度为O(N)完成原问题的要求，该怎么实现？
 *
 * @author nuonuo
 * @create 2021-01-10 13:16
 */
public class Josephus {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = node;
        System.out.println(josephus(node, 3).val);

    }
    private static Node josephus(Node node, int num) {
        int t = 0;
        Node cur = node;
        Node per = null;
        while (!cur.equals(per)) {
            t++;
            if (t == num) {
                t = 0;
                cur = cur.next;
                per.next = cur;
            } else {
                per = cur;
                cur = cur.next;
            }
        }
        return cur;
    }

    private static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }
    }

}
