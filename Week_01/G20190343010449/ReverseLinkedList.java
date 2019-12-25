class ReverseLinkedList {

    public ListNode reverseLinkedList(ListNode head) {
        ListNode temp = null;
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}
