package com.cheng.linkedList;

import java.util.HashSet;

/**
 * 删除无序单链表中值重复出现的结点
 *
 * 方法1：使用hashset
 * @author nuonuo
 * @create 2021-02-28 11:57
 */
public class DeleteRepeatedNodes {
    public static void main(String[] args) {
        Node node1 = new Node(4);
        node1.next = new Node(2);
        node1.next.next = new Node(1);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        System.out.println(deleteRepeatedNodes(node1));
    }
    private static Node deleteRepeatedNodes(Node head) {
        if (head == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        Node cur = head;
        Node pre = null;
        while (cur != null) {
            if (set.contains(cur.val)) { //发现重复
                pre.next = cur.next;
            } else { //不重复
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
        return head;

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
