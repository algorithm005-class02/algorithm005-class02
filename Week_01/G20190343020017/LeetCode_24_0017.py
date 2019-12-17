class Solution:
    # 方法一：迭代
    def swapPairs(self, head: ListNode) -> ListNode:
        if head and head.next:
            head, head.next, head.next.next = head.next, head, self.swapPairs(head.next.next)
        return head