package com.cheng.linkedList;

/**
 * 程序员代码面试指南  打印两个有序链表的公共部分
 * @author nuonuo
 * @create 2021-01-04 13:19
 */
public class PrintCommonality {
    private class Node {
        Node next;
        int val;
    }



    /**
     * 思路:因为是有序的 所以容易， 只需要依次比较两个链表的结点大小
     * 1.如果n1.val > n2.val     ->   n1 = n1.next
     * 2.如果n2.val > n1.val     ->   n2 = n2.next
     * 3.如果n1.val == n2.val   ->    打印出来 然后 n1 = n1.next  n2 = n2.next
     * 直到某个链表到null
     * @param n1
     * @param n2
     */
    private static void printLinkedCommonality(Node n1, Node n2) {

        while (n1 != null && n2 != null) {
            if (n1.val > n2.val) {
                n1 = n1.next;
            } else if (n2.val > n1.val) {
                n2 = n2.next;
            } else {
                System.out.println(n1.val);
                n1 = n1.next;
                n2 = n2.next;
            }
        }
    }
}
