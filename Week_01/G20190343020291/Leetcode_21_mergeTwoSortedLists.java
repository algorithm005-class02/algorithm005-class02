/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class Leetcode_21_mergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                newTail.next = l1;
                newTail = l1;
                l1 = l1.next;
            } else {
                newTail.next = l2;
                newTail = l2;
                l2 = l2.next;
            }
        }

        newTail.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
