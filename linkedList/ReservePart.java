package com.cheng.linkedList;

/**
 * 反转部分单向链表
 *
 * @author nuonuo
 * @create 2021-01-04 14:53
 */
public class ReservePart {
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        System.out.println(reserveLinkedListPart(node, 1,4));
    }
    /**
     * 思路：  和反转整个链表类似，只需要在from到to的区域才进行反转就行了
     *
     * @param node
     * @param from
     * @param to
     */

    private static Node reserveLinkedListPart(Node node, int from, int to) {
        Node pre = null, cur = node, next = null;
        Node left = null, right = null;//需要反转的区域的外边界
        int t = 0;
        while (cur != null) {
            t++;
            if (t < from) { //1,。当from之前的区域，不断更新left边界
                pre = cur;
                left = cur;//更新边界
                cur = cur.next;
                continue;
            }
            if (t > to) {//2.到达to之后的区域，更新right区域
                right = cur;
                break;
            }
            //3.需要反转的区域
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        if (left != null) {//4.表示不是从头就开始反转的
            //from != 1
            left.next.next = right;
            left.next = pre;
            return node;
        }
        //6.表示是从头就开始反转的
        node.next = right;
        return pre;

    }

    private static class Node {
        Node next;
        int val;

        @Override
        public String toString() {
            return val + " " + next;
        }

        public Node(int val) {
            this.val = val;
        }
    }
}
