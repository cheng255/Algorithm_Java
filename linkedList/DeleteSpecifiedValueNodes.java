package com.cheng.linkedList;


/**
 * 在单链表中删除指定值的结点
 * 思路:  遍历到的第一个值不是val的结点就是newHead  然后后面删除就行
 * @author nuonuo
 * @create 2021-02-28 12:20
 */
public class DeleteSpecifiedValueNodes {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(1);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        System.out.println(deleteSpecifiedNodes(node1, 1));
    }
    private static Node deleteSpecifiedNodes(Node head, int n) {
        Node newHead = null;
        Node cur = head;
        Node pre = null;
        while (cur != null && cur.val == n) {
            cur = cur.next;
        }
        if (cur == null) {//代表全是特殊值
            return null;
        }
        newHead = cur;
        cur = newHead.next;
        pre = newHead;
        while (cur != null) {
            if (cur.val == n) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return newHead;

    }
    private static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return val + " " + next;
        }
    }
}
