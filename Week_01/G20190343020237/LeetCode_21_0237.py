#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#
# https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
#
# algorithms
# Easy (58.50%)
# Likes:    752
# Dislikes: 0
# Total Accepted:    150.9K
# Total Submissions: 257.4K
# Testcase Example:  '[1,2,4]\n[1,3,4]'
#
# 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
#
# 示例：
#
# 输入：1->2->4, 1->3->4
# 输出：1->1->2->3->4->4
#
#
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        # T: O(L1+L2), S: O(1)
        # 208/208 cases passed (56 ms)
        # Your runtime beats 29.86 % of python3 submissions
        # Your memory usage beats 99.38 % of python3 submissions (12.7 MB)

        head = ListNode(-1)
        prev = head
        while l1 and l2:
            if l1.val < l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next

        if l1:
            prev.next = l1
        else:
            prev.next = l2

        return head.next


# @lc code=end
