/**
 * 反转链表
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class Leetcode_206_reverseLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode p = head.next;
            head.next = newHead;
            newHead = head;
            head = p;
        }

        return newHead;
    }

    public ListNode reverseList2(ListNode head) {
        return reverseList(head, null);
    }

    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }

        ListNode p = head.next;
        head.next = newHead;

        return reverseList(p, head);
    }

}
