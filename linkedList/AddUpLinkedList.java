package com.cheng.linkedList;

/**
 * 两个单链表生成相加链表      重要
 * <p>
 * 思路：  1：使用栈
 * 2: 反转链表
 * 注意：  链表可能很长  相加数字很大  所以不能用int
 * <p>
 * <p>
 * 学到 ：相加这样写          while (head1 != null || head2 != null) {
 * a = head1 == null ? 0 : head1.val;
 * b = head2 == null ? 0 : head2.val;
 * }
 *
 * @author nuonuo
 * @create 2021-02-18 19:34
 */
public class AddUpLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(4);
        node1.next = new Node(2);
        node1.next.next = new Node(1);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        Node node2 = new Node(4);
        node2.next = new Node(2);
        node2.next.next = new Node(1);
        node2.next.next.next = new Node(4);
        node2.next.next.next.next = new Node(5);
        System.out.println(addUpLinedList(node1, node2));
    }

    private static Node addUpLinedList(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node addHead = null;
        //1.反转两个链表
        head1 = reverse(head1);
        head2 = reverse(head2);
        //2.相加
        addHead = add(head1, head2);
        //3.反转相加后的链表  因为相加操作结合了反转  所以这里不需要
        return addHead;
    }

    //相加
    private static Node add(Node head1, Node head2) {
        Node addNode = null;
        Node pre = null;
        int a = 0;
        int b = 0;
        int c = 0;//往上升的数
        int n = 0;//总和数
        //这块是反转和加法一起执行
        while (head1 != null || head2 != null) {
            a = head1 == null ? 0 : head1.val;
            b = head2 == null ? 0 : head2.val;
            n = a + b + c;
            pre = addNode;
            addNode = new Node(n % 10);
            addNode.next = pre;
            c = n / 10;
            if (head2 != null)
                head2 = head2.next;
            if (head1 != null)
                head1 = head1.next;
        }
        if (c == 1) {
            pre = addNode;
            addNode = new Node(1);
            addNode.next = pre;
        }
        return addNode;
    }

    //反转链表
    private static Node reverse(Node head) {
        Node pre = null;
        Node nex = null;
        while (head != null) {
            nex = head.next;
            head.next = pre;
            pre = head;
            head = nex;
        }
        return pre;
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
