#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#
# https://leetcode-cn.com/problems/merge-two-sorted-lists/description/
#
# algorithms
# Easy (57.94%)
# Likes:    716
# Dislikes: 0
# Total Accepted:    141.7K
# Total Submissions: 242.8K
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
# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        i, j = l1, l2
        res = ListNode(0)
        p = res
        while i and j:
            if i.val < j.val:
                p.next = ListNode(i.val)
                i = i.next
            else:
                p.next = ListNode(j.val)
                j = j.next
            # print(p)
            p = p.next
        if i:
            p.next = i
        if j:
            p.next = j
        return res.next

# @lc code=end
