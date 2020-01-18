/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode cur = head;
        int sum = 0;
        while(cur != null) {
            sum = sum * 2 + cur.val;
            cur = cur.next;
        }
        return sum;
    }
}