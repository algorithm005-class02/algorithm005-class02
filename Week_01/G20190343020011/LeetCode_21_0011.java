package leetcode.week01;

import util.ListNode;

//将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 示例：
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
//
// Related Topics 链表
public class LeetCode_21_0011 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), end = head;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2!=null && l1.val > l2.val)) {
                end.next = l2;
                l2 = l2.next;
                end = end.next;
            }else{
                end.next = l1;
                l1 = l1.next;
                end = end.next;
            }
        }
        return head.next;
    }

}
