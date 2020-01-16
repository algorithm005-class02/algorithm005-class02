"""
思路 1：
哈希表
哈希表存已经访问过的节点，如果访问下一个节点时，哈希表中存在，则有环
时间 O(n) 空间O(n)
思路 2：
快慢指针
两个指针，一个每次走两步，一个每次走一步，快指针落后慢指针一步，如果有环，那么他们最终一定相遇
时间 O(n) 空间O(1)
"""

#思路 1 48ms 16.2mb
class Solution1:
    def hasCycle(self, head: ListNode) -> bool:
        buffer_set = set()
        while head:
            if head in buffer_set:
                return True
            buffer_set.add(head)
            head = head.next
            
        return False

#思路 2 52ms 16mb
class Solution2:
    def hasCycle(self, head: ListNode) -> bool:
        if not head:
            return False
        slow = head
        fast = head.next
        while slow and fast and fast.next:
            if slow == fast:
                return True
            slow = slow.next
            fast = fast.next.next
        return False
        