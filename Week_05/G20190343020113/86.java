/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode cur = head;
        if(head == null) {
            return head;
        }
        ListNode firstP = new ListNode(0);
        ListNode p = firstP;
        ListNode firstQ = new ListNode(0);
        ListNode q = firstQ;
        while(cur != null) {
            if(cur.val < x) {
                p.next = cur;
                p = p.next;
            } else {
                q.next = cur;
                q = q.next;
            }
            cur = cur.next;
        }
        q.next = null;
        p.next = firstQ.next;
        return firstP.next;
    }
}