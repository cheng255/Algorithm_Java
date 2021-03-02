package com.cheng.linkedList;

/**
 * 单链表的选择排序  空间复杂度O(1)
 *
 * 思路：每次找到最小的结点  然后将其删掉 并连接成新链表
 *
 * @author nuonuo
 * @create 2021-03-01 10:54
 */
public class SelectSort {
    public static void main(String[] args) {
        Node node1 = new Node(4);
        node1.next = new Node(2);
        node1.next.next = new Node(1);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        System.out.println(selectSort(node1));
    }
    private static Node selectSort(Node head) {
        if (head == null) {
            return null;
        }
        Node newHead = null;//新链表头
        Node newTail = null;//新链表尾
        while (head != null) {
            Node cur = head;
            Node pre = null;
            Node minPre = null;//最小结点的前一个
            Node minNode = cur;//最小结点
            //1.找到最小的结点
            while (cur != null) {
                if (cur.val < minNode.val) {
                    minNode = cur;//选择最小元素的过程
                    minPre = pre;
                }
                pre = cur;
                cur = cur.next;
            }
            //2.连接到新链表上
            if (newHead == null) {//第一个最小结点设置为头
                newHead = minNode;
                newTail = newHead;
            } else {
                newTail.next = minNode;
                newTail = minNode;
            }
            //3.在原链表中删掉
            //注意：如果找到的minNode是cur（本轮第一个） 那么要特殊处理
            if (minPre == null) {
                head = head.next;
            } else {
                minPre.next = minNode.next;
            }
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
