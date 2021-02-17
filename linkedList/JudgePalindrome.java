package com.cheng.linkedList;

import java.util.Stack;

/**
 * 判断一个链表是否为回文结构
 * <p>
 * 思路：1.用快慢指针的方法找到中间界结点
 * 2.并且用栈将前半部分压入栈中  然后比较
 * <p>
 * 进阶：  时间复杂度O(N)   空间复杂度O(1)
 * <p>
 * <p>
 * 思路：可以将其中一半逆置  然后比较
 *
 * @author nuonuo
 * @create 2021-02-17 19:36
 */
public class JudgePalindrome {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        node1.next = new Node(2);
        node1.next.next = new Node(3);
        node1.next.next.next = new Node(3);
        node1.next.next.next.next = new Node(2);
        node1.next.next.next.next.next = new Node(1);
        System.out.println(isPalindrome(node1));
        System.out.println(isPalindrome1(node1));
    }

    private static boolean isPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        Node low = head;
        Node fast = head.next;
        Stack<Node> stack = new Stack<>();//装前一半结点 low走过的结点
        stack.push(low);
        int sum = 1;//记录链表长度
        while (fast != null) {
            fast = fast.next;
            sum++;
            if (fast != null) {
                low = low.next;
                stack.push(low);
                fast = fast.next;
                sum++;
            }
        }
//        System.out.println(low.val);
//        System.out.println(sum);
        //此时low指向中间的结点,需要将他调整到中间结点的下一个
        low = low.next;
        if ((sum & 1) == 1) {//奇数
            stack.pop();
        }
        while (!stack.isEmpty()) {
            if (low.val != stack.pop().val) {
                return false;
            }
            low = low.next;
        }
        return true;
    }

    private static boolean isPalindrome1(Node head) {
        if (head == null) {
            return false;
        }
        Node pre = null;//low的前一个结点
        Node low = head;
        Node fast = head.next;
        int sum = 1;//记录链表长度
        while (fast != null) {
            fast = fast.next;
            sum++;
            if (fast != null) {
                //将前一半逆置
                Node temp = low.next;
                low.next = pre;
                pre = low;
                low = temp;//往后移动
                fast = fast.next;
                sum++;
            }
        }
        //此时low指向中间的结点
        //  此时的结构   1<-2 3->2->1       1<-2 3->3->2->1
        //然后向两边扩散并且比较就行了  这里让pre向左扩散   fast向右扩散
        fast = low.next;
        if ((sum & 1) == 0) {//偶数
            low.next = pre;
            pre = low;
        }
        while (fast != null) {
            if (fast.val != pre.val) {
                return false;
            }
            fast = fast.next;
            pre = pre.next;
        }
        return true;
    }

    private static class Node {
        Node next;
        int val;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }
    }

}
