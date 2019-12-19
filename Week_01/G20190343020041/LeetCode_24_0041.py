# 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
#
# 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
#
#
#
# 示例:
#
# 给定 1->2->3->4, 你应该返回 2->1->4->3.
#
# Related Topics 链表


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for singly-linked list.
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution(object):
    def swapPairs(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        dummy = pre = ListNode(0)
        pre.next = head
        while pre.next and pre.next.next:
            a = pre.next
            b = pre.next.next
            pre.next, a.next, b.next = b, b.next, a
            pre = a
        return dummy.next

# leetcode submit region end(Prohibit modification and deletion)
