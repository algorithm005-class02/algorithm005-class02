"""
反转 k 个，可以看做吧整个链表分成 n 个 由 k 个节点组成的链表，每个链表进行反转
需要记录一下 相关的指针，最后要把链表给串起来
时间: O(n * K) 空间: O(1)
"""

#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

# 48ms 13.3mb
class Solution:
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        if k == 1:
            return head
        dummy = ListNode(0)
        dummy.next = head
        pre = dummy
        end = dummy
        while pre.next:
            start = pre.next
            for i in range(k):
                end = end.next
                if not end:
                    break
            if not end:
                break
            next_node = end.next
            end.next = None
            pre.next = self.reverse_linked_list(start)
            start.next = next_node
            pre = start
            end = start
        return dummy.next


    def reverse_linked_list(self, head: ListNode) -> ListNode:
        pre = None
        cur = head
        while cur:
            next_node = cur.next
            cur.next = pre
            pre = cur
            cur = next_node
        return pre
        