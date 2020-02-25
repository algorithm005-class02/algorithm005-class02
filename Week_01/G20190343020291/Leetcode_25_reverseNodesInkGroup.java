/**
 * K个一组翻转链表
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 */
public class Leetcode_25_reverseNodesInkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int count = 0;
        ListNode p = head;
        while (p != null && count != k) {
            p = p.next;
            count++;
        }

        if (count != k) {
            return head;
        }

        p = reverseKGroup(p, k);

        while (count -- > 0) {
            ListNode tmp = head.next;
            head.next = p;
            p = head;
            head = tmp;
        }

        return p;
    }
}
