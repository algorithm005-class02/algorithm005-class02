#
# @lc app=leetcode.cn id=21 lang=python3
#
# [21] 合并两个有序链表
#

# @lc code=start
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 解法一，先对两个需要合并的有序链表判断是否为空，如果单个为空那么就是直接返回非空者
# 然后判断节点值的大小，小值的留下，再对比小值的下一个节点与大值节点，同理小值节点留下
# 合并的同时构造有序链表。这里往下对比采用递归的形式，递归就是先逐渐往下推导至初始点，
# 或者说是起始点（已知值），然后再从已知值开始一步步往后赋值，直到当前的N位置，即得到
# 想要的当前递归值。
# class Solution:
#     def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
#         if l1 is None:
#             return l2
#         if l2 is None:
#             return l1
#         if l1.val < l2.val:
#             l1.next = self.mergeTwoLists(l1.next, l2)
#             return l1
#         else:
#             l2.next = self.mergeTwoLists(l1, l2.next)
#             return l2

# 解法二，这个解法是利用判断语句if and 多条件语法，如果其中一值或两值为None，那么就会跳出判断语句
# 然后直接返回节点值（此时采用 or 返回即可，因为两值不可能同时存在）。
# 在判断语句里，利用交换赋值的方式保证左边的值始终小于右边的值，这样后面只需要写一条语句，
# 即一条迭代语句，原理同上一解法。
class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if l1.val > l2.val: l1, l2 = l2, l1
            l1.next = self.mergeTwoLists(l1.next, l2)
        return l1 or l2


# @lc code=end

