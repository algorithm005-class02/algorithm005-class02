/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    
    //迭代的方法
    // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    //     ListNode head = new ListNode(-1);
    //     ListNode cur = head;
    //     while (l1 != null && l2 != null) {
    //         if (l1.val <= l2.val) {
    //             cur.next = l1;
    //             l1 = l1.next;
    //         } else {
    //             cur.next = l2;
    //             l2 = l2.next;
    //         }
    //         cur = cur.next;
    //     }
    //     cur.next = l1 == null ? l2 : l1;
    //     return head.next;
    // }

    // 递归
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }



    
}
// @lc code=end

