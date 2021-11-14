package day03;

/**
 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 示例 1：

 输入：head = [1,2,3,4,5], n = 2
 输出：[1,2,3,5]
 示例 2：

 输入：head = [1], n = 1
 输出：[]
 示例 3：

 输入：head = [1,2], n = 1
 输出：[1]
  
 提示：

 链表中结点的数目为 sz
 1 <= sz <= 30
 0 <= Node.val <= 100
 1 <= n <= sz

 思路：很简单    注意小技巧 ：   前链表头部构建虚拟头节点 可以简化代码！！！

 */
public class 删除链表的倒数第n个结点021 {

     // Definition for singly-linked list.
      private static class ListNode {
         int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode fast = temp;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode low = temp;
        while (fast.next != null) {
            fast = fast.next;
            low = low.next;
        }
        low.next = low.next.next;
        return temp.next;
    }
}
