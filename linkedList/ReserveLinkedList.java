package com.cheng.linkedList;

/**
 * 反转单向和双向链表
 *
 * @author nuonuo
 * @create 2021-01-04 14:42
 */
public class ReserveLinkedList {
    /**
     * 反转单链表思路：定义两个指针 cur pre   每次执行 temp = cur.next; cur.next = pre;  pre = cur; cur = temp;
     * 直到cur == null
     *
     * @param node
     */
    private static SingleNode reserve(SingleNode node) {
        SingleNode pre = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

    /**
     * 反转双向链表
     */
    private static DoubleNode reserve(DoubleNode node) {
        DoubleNode pre = null, next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            node.pre = next;//只多了这一步
            pre = node;
            node = next;
        }
        return pre;
    }

    private class SingleNode {
        SingleNode next;
        int val;
    }

    private class DoubleNode {
        DoubleNode pre;
        DoubleNode next;
        int val;
    }

}
