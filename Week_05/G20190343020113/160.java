/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n1 = 0;
        int n2 = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while(curA != null) {
            n1++;
            curA = curA.next;
        }
        while(curB != null) {
            n2++;
            curB = curB.next;
        }
        curA = headA;
        curB = headB;
        int len = n1;;
        if(n1 > n2) {
            int diff = n1 - n2;
            for(int i = 0;i < diff;i++) {
                curA = curA.next;
            }
            len = n2;
        } else if(n1 < n2) {
            int diff = n2 - n1;
            for(int i = 0;i < diff;i++) {
                curB = curB.next;
            }
        }
        for(int i = 0;i<len;i++) {
            if(curB == curA) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}