#
# @lc app=leetcode.cn id=206 lang=python3
#
# [206] 反转链表
#
# https://leetcode-cn.com/problems/reverse-linked-list/description/
#
# algorithms
# Easy (65.83%)
# Likes:    673
# Dislikes: 0
# Total Accepted:    128.7K
# Total Submissions: 195.5K
# Testcase Example:  '[1,2,3,4,5]'
#
# 反转一个单链表。
#
# 示例:
#
# 输入: 1->2->3->4->5->NULL
# 输出: 5->4->3->2->1->NULL
#
# 进阶:
# 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
#
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        """
        反转链表:

        A -> B -> C -> D -> NIL

        p, q
        A, B: A <- B
        B, C: B <- C
        C, D: D <- C
        D, None

        """

        # Time: O(n), Space: O(1)
        p, q = None, head       # p:prev, q: current,

        while q:
            # next = q.next
            # q.next = p
            # p = q
            # q = next

            # next = q.next       # save tmp pointer
            # q.next = p          # do something
            # p, q = q, next      # update p, q

            q.next, p, q = p, q, q.next

        return p


# @lc code=end
