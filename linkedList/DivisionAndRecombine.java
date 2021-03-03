package com.cheng.linkedList;

/**
 * 按照左右划分的方式重新组合单链表
 * @author nuonuo
 * @create 2021-03-02 13:35
 */
public class DivisionAndRecombine {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(4);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        node1.next.next.next.next.next = new Node(6);
        System.out.println(划分组合(node1));
    }
    private static Node 划分组合(Node head) {
        //1.首先找到后半部分的第一个元素  使用快慢指针
        Node low = head;
        Node fast = head;
        if (fast.next == null) { //不足两个
            return head;
        }
        fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            if (fast.next != null) {
                fast = fast.next;
                low = low.next;
            }
        }
        low = low.next;//此时low指向后半部分的第一个结点
        //2.左右依次连接
        Node first = head.next;
        Node temp = head;
        Node second = low;
        while (first != low && second != null) {
            Node nexSecond = second.next;
            Node nexFirst = first.next;
            temp.next = second;
            temp.next.next = first;
            temp = temp.next.next;
            second = nexSecond;
            first = nexFirst;
        }
        temp.next = second;
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
