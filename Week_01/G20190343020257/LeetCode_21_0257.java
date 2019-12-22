class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode head = ret;
        while (l1 != null && l2 != null) {
           
                if (l1.val > l2.val) {
                    head.next = l2;
                    l2 = l2.next;
                } else {
                    head.next = l1;
                    l1 = l1.next;
                }
                head = head.next;
        }
        head.next = l1 == null ? l2 : l1;
        return ret.next;
    }
}
