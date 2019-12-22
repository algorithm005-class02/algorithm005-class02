class Solution:
    # 方法一：收到206题递归方法启发，递归反转
    def reverseKGroup(self, head: ListNode, k: int) -> ListNode:
        node = self._reverseKGroup(head, k, k)
        return node if node else head

    # 反转，如果 return None 代表长度不够，反转失败
    def _reverseKGroup(self, head: ListNode, k: int, i: int) -> ListNode:
        if not head:
            return head
        if i > 1:
            node = self._reverseKGroup(head.next, k, i - 1)
            if not node:
                return None
            head.next.next, head.next, head = head, head.next.next, node
        else:
            node = self._reverseKGroup(head.next, k, k)
            if node:
                head.next = node
        return head