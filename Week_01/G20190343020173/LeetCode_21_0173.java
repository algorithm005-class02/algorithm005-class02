package org.crayzer.leetcode.editor.en.list;

public class LeetCode_21_MergeTwoSortedLists {
     class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode soldier = new ListNode(0);
        ListNode p = soldier;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        if (l1 != null) p.next = l1;
        if (l2 != null) p.next = l2;

        return soldier.next;
    }
}
