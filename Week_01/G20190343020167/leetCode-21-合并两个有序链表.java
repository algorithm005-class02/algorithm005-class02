class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode l3 = l;
        while (l1 != null && l2 != null) {
           if (l1.val <= l2.val) {
               l3.next = l1;
                l1 = l1.next;
           } else {
                l3.next = l2;
                l2 = l2.next;
            }
            l3 = l3.next;
        }
        l3.next = l1 != null ? l1 : l2;
        return l.next;
    }
}