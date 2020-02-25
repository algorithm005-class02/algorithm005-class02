/**
 * 两两交换链表中的节点
 * https://leetcode.com/problems/swap-nodes-in-pairs/
 */
public class Leetcode_24_swapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = swapPairs(head.next.next);
        p.next = head;

        return p;
    }
}
