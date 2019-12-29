package org.crayzer.leetcode.editor.en.list;

import java.util.HashSet;
import java.util.Set;

public class LeetCode_141_LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (slow != fast) {
                if (fast.next == null || fast.next.next == null) {
                    return false;
                }

                slow = slow.next;
                fast = fast.next.next;
            }

            return true;
        }
    }

    class Solution1 {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> nodesSeen = new HashSet<>();
            ListNode node = head;

            while (node != null) {
                if (nodesSeen.contains(node)) {
                    return true;
                }

                nodesSeen.add(node);
                node = node.next;
            }

            return false;
        }
    }
}
