package com.cheng.linkedList;

/**
 * 合并两个有序的单链表
 *
 * @author nuonuo
 * @create 2021-03-02 13:04
 */
public class MergeOrderedLinkedLists {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(3);
        node1.next.next = new Node(4);
        node1.next.next.next = new Node(4);
        node1.next.next.next.next = new Node(5);
        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(3);
        node2.next.next.next = new Node(4);
        node2.next.next.next.next = new Node(5);
        System.out.println(合并(node1, node2));
    }

    private static Node 合并(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;
        Node cur1 = head1;
        Node cur2 = head2;
        Node newHead = null;
        //1.确定头节点
        if (head1.val < head2.val) {
            newHead = head1;
            cur1 = head1.next;
        } else {
            newHead = head2;
            cur2 = head2.next;
        }
        Node newCur = newHead;
        //2.从小到大依次连接
        while (cur1 != null) {
            while (cur2 != null) {
                if (cur2.val < cur1.val) {
                    newCur.next = cur2;
                    newCur = newCur.next;
                    cur2 = cur2.next;
                    continue;
                }
                newCur.next = cur1;
                newCur = newCur.next;
                break;
            }
            if (cur2 == null) {
                newCur.next = cur1;
                break;
            }
            cur1 = cur1.next;
        }
        if (cur1 == null) {
            newCur.next = cur2;
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
