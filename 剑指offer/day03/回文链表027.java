package day03;

/**
 给定一个链表的 头节点 head ，请判断其是否为回文链表。

 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。
 示例 1：
 输入: head = [1,2,3,3,2,1]
 输出: true
 示例 2：
 输入: head = [1,2]
 输出: false
 提示：
 链表 L 的长度范围为 [1, 105]
 0 <= node.val <= 9

 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

 */
public class 回文链表027 {
    public boolean isPalindrome(ListNode head) {
        int n = 0;//1.计算链表长度
        for (ListNode cur = head; cur != null; cur = cur.next) {
            n++;
        }
        if (n == 1) {
            return true;
        }
        n /= 2;
        //6 3   7 3
        //2. 将后半部分反转
        ListNode preHead = head, postHead = null;
        int i = 1;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            if (i == n) {//找到前半部分的最后一个结点
                postHead = reverse(cur.next);//将后半部分反转
                cur.next = null;//前半部分尾部截断
                break;
            }
            i++;
        }
        //System.out.println(preHead.val + "," + postHead.val);
        //3. 判断前后两部分是否相同
        while (preHead != null && postHead != null) {
            if (preHead.val != postHead.val) {
                return false;
            }
            preHead = preHead.next;
            postHead = postHead.next;
        }
        return true;

    }
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
