package day03;

/**
 剑指 Offer II 024. 反转链表
 给定单链表的头节点 head ，请反转链表，并返回反转后的链表的头节点。
 示例 1：
 输入：head = [1,2,3,4,5]
 输出：[5,4,3,2,1]
 示例 2：

 输入：head = [1,2]
 输出：[2,1]
 示例 3：

 输入：head = []
 输出：[]
 提示：
 链表中节点的数目范围是 [0, 5000]
 -5000 <= Node.val <= 5000
 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？


 思路：很简单
 */
public class 反转链表024 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode reverseList1(ListNode head) {
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
    //递归
    public ListNode reverseList2(ListNode head) {
        return helper(null, head);

    }
    public ListNode helper(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }
        ListNode nex = cur.next;
        cur.next = pre;
        return helper(cur, nex);
    }

}
