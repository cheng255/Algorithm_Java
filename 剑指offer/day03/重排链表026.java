package day03;

import java.util.ArrayList;
import java.util.List;

/**
 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
  L0 → L1 → … → Ln-1 → Ln 
 请将其重新排列后变为：
 L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

 示例 1:
 输入: head = [1,2,3,4]
 输出: [1,4,2,3]
 示例 2:
 输入: head = [1,2,3,4,5]
 输出: [1,5,2,4,3]
 提示：
 链表的长度范围为 [1, 5 * 104]
 1 <= node.val <= 1000


 思路：    1.找到中点 + 反转链表 + 重组        2.用数组保存，然后根据下标重组

            我一直思考的是第一种方法   做题加思考时间大概半小时   太长啦！！！！
 */
public class 重排链表026 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public void reorderList2(ListNode head) {
        //1.存起来
        List<ListNode> nodes = new ArrayList<>();
        for (ListNode cur = head; cur != null; cur = cur.next) {
            nodes.add(cur);
        }
        //2.按照下标重组
        ListNode cur = head;
        int l = 1, r = nodes.size()-1;
        while (l <= r) {
            cur.next = nodes.get(r--);
            cur = cur.next;
            if (l <= r) {
                cur.next = nodes.get(l++);
                cur = cur.next;
            }
        }
        cur.next = null;
    }
    public void reorderList(ListNode head) {
        int sum = 0;//1.计算结点个数
        ListNode cur;
        for (cur = head; cur != null; cur = cur.next) {
            sum++;
        }
        sum = (sum + 1) / 2;//sum这表示后半部分的结尾
        //2.将后半部分反转
        cur = head;
        for (int i = 0; i < sum; i++) {
            cur = cur.next;
        }
        ListNode cur2 = reverseList(cur);

        ListNode cur1 = head.next;
        // System.out.println(cur2.val);
        // System.out.println(cur1.val);
        //3.重组链表
        cur = head;
        while (cur2 != null && cur1 != null) {
            cur.next = cur2;
            cur2 = cur2.next;
            cur = cur.next;

            cur.next = cur1;
            cur1 = cur1.next;
            cur = cur.next;
        }
        //4.两种情况     前后正好相同数量     后面多一个结点cur2
        cur.next = cur2;
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
