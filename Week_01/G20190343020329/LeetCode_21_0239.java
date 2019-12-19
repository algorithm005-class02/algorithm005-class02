/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        ListNode head = new ListNode(0);
        if (l1.val <= l2.val) {
            head.val = l1.val;
            head.next = l1;
        } else {
            head.val = l2.val;
            head.next = l2;
        }
        ListNode last = head;
        while (null != l1 && null != l2) {
            if (l1.val == l2.val) {
                ListNode one = new ListNode(0);
                one.val = l1.val;
                ListNode two = new ListNode(0);
                two.val = l2.val;
                one.next = two;

                last.next = one;
                last = two;

                l1 = l1.next;
                l2 = l2.next;
            } else if (l1.val < l2.val) {
                ListNode one = new ListNode(0);
                one.val = l1.val;

                last.next = one;
                last = one;

                l1 = l1.next;
            } else {
                ListNode one = new ListNode(0);
                one.val = l2.val;

                last.next = one;
                last = one;

                l2 = l2.next;
            }
        }
        if (null != l1) {
            while (null != l1) {
                ListNode one = new ListNode(0);
                one.val = l1.val;

                last.next = one;
                last = one;

                l1 = l1.next;
            }
        }
        if (null != l2) {
            while (null != l2) {
                ListNode one = new ListNode(0);
                one.val = l2.val;

                last.next = one;
                last = one;

                l2 = l2.next;
            }
        }
        return head.next;
    }
}