package day03;

/**
 给定两个 非空链表 l1和 l2 来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 可以假设除了数字 0 之外，这两个数字都不会以零开头。
 示例1：
 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 输出：[7,8,0,7]
 示例2：

 输入：l1 = [2,4,3], l2 = [5,6,4]
 输出：[8,0,7]
 示例3：

 输入：l1 = [0], l2 = [0]
 输出：[0]
  
 提示：
 链表的长度范围为 [1, 100]
 0 <= node.val <= 9
 输入数据保证链表代表的数字无前导 0
  

 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。

    思路：1.反转链表然后进行相加                    2.进阶不适用反转
                                                    使用数组先处理一遍和，然后再赋值。
                                                挺简单的，但做了半个小时   麻了
 */
public class 链表中的两数相加025 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //用了额外空间，但没有修改原链表结构
    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode h1 = l1;int size1 = 0;
        ListNode h2 = l2;int size2 = 0;

        //1.先计算两个链表长度的差值
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                size1++;
                h1 = h1.next;
            }
            if (h2 != null) {
                size2++;
                h2 = h2.next;
            }
        }
        //2.链表相加,将每一位的和放到数组里
        int[] sums = new int[Math.max(size1, size2)]; int i = 0;
        h1 = l1; h2 = l2;
        while (size1 > 0) {
            int sum = 0;
            //2.1长的一方加到和短的一样时两个一起加
            if (size1 > size2) {
                sum += h1.val;
                h1 = h1.next;
                --size1;
            } else if (size2 > size1) {
                sum += h2.val;
                h2 = h2.next;
                --size2;
            } else {
                sum += h1.val;
                h1 = h1.next;
                sum += h2.val;
                h2 = h2.next;
                --size2;
                --size1;
            }
            sums[i++] = sum;//把和存到数组里
        }

        //3.根据 sums 数组计算真正的结点值
        int r = 0;
        for (i = sums.length-1; i >= 0; i--) {
            int temp = r + sums[i];
            sums[i] = temp % 10;
            r = temp / 10;
        }

        //4.将值赋给新链表
        ListNode newHead = null;ListNode cur = null;
        if (r != 0) {
            newHead = new ListNode(r);
            cur = newHead;
        }
        for (int sum : sums) {
            if (newHead == null) {
                newHead = new ListNode(sum);
                cur = newHead;
            } else {
                cur.next = new ListNode(sum);
                cur = cur.next;
            }
        }

        return newHead;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode h1 = reverseList(l1);
        ListNode h2 = reverseList(l2);
        ListNode newHead = null;ListNode cur = null;
        int r = 0;//既当进位又当和
        while (h1 != null || h2 != null) {
            if (h1 != null) {
                r += h1.val;
                h1 = h1.next;
            }
            if (h2 != null) {
                r += h2.val;
                h2 = h2.next;
            }
            if (newHead == null) {
                newHead = new ListNode(r % 10);
                cur = newHead;
            } else {
                cur.next = new ListNode(r % 10);
                cur = cur.next;
            }
            r /= 10;
        }
        if (r != 0) {
            cur.next = new ListNode(r);
        }
        return reverseList(newHead);
    }
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nex;
        }
        return pre;
    }
}
