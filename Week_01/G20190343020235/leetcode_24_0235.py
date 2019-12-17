"""
思路 1：
递归
n1->n2->...->nk 两两交换，n2.next = n1, n1.next = swapPairs(next.next)

思路 2：
迭代
新增一个节点，作为哨兵节点，其 next 指向头节点
然后两两调换即可
"""

# 1 12ms 12.7mb
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head:
            return None
        if not head.next:
            return head
        next_node = head.next
        head.next = self.swapPairs(next_node.next)
        next_node.next = head
        return next_node

# 2 32ms 12.7mb
class Solution:
    def swapPairs(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        pre_head = ListNode(0)
        pre_head.next = head
        tmp_next = pre_head
        while tmp_next.next and tmp_next.next.next:
            start = tmp_next.next
            end = tmp_next.next.next
            start.next = end.next
            end.next = start
            tmp_next.next = end
            tmp_next = start
            
        return pre_head.next