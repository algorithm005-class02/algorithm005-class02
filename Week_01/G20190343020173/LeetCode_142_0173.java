package org.crayzer.leetcode.editor.en.list;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_142_LinkedListCycle2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution2 {

        private ListNode getIntersect(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return slow;
                }
            }

            return null;
        }

        public ListNode detectCycle(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode intersect = getIntersect(head);
            if (intersect == null) {
                return null;
            }

            ListNode ptr1 = head;
            ListNode ptr2 = intersect;

            while (ptr1 != ptr2) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }

            return ptr1;
        }
    }

    class Solution1 {
        public ListNode detectCycle(ListNode head) {
            Set<ListNode> nodesSeen = new HashSet<>();
            ListNode node = head;

            while (node != null) {
                if (nodesSeen.contains(node)) {
                    return node;
                }

                nodesSeen.add(node);
                node = node.next;
            }

            return null;
        }
    }


}
