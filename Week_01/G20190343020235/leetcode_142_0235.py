"""
与 141 类似，不过这次要返回环的起始节点
思路 1：
哈希表，首次遇到重复的即为环开始的节点
思路 2：
Floyd 算法：第一阶段，找到是否有环，第二阶段，用相遇节点找到环的入口
阶段 1
环中的节点 0-C-1编号，C 为环的长度，非环节点从-F到-1 编号，F 是环外节点的数量
F 次迭代后慢指向了0 而快指针指向某个节点 h其中 F=h mod C 因为快指针在F次迭代中遍历了2F 个节点，且恰好有 F 个在环中
继续迭代C-h次慢指针指向了C-h号节点，快指针也会指向相同的节点，因为快指针从 h号节点出发遍历了 2(C-h)个节点
h+2(C-h) = 2C-h = (C-h)mod C 因此，如果列表是有环的，快慢指针最后会相遇
阶段 2
给定阶段 1 找到的相遇点，阶段 2 将找到环的入口。首先我们初始化额外的两个指针： ptr1 ，指向链表的头， ptr2 指向相遇点。然后，我们每次将它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点。
时间 O(n) 空间O(1)
"""

#思路 1 52ms 16.3mb
class Solution1:
    def detectCycle(self, head: ListNode) -> ListNode:
        buffer_set = set()
        while head:
            if head in buffer_set:
                return head
            buffer_set.add(head)
            head = head.next
            
        return None
#思路 2 52ms 16.1mb
class Solution2:
    def get_intersect_node(self, head: ListNode) -> ListNode:
        slow, fast = head, head
        while slow and fast and fast.next:
            slow = slow.next
            fast = fast.next.next
            if slow == fast:
                return slow
        return None
    def detectCycle(self, head: ListNode) -> ListNode:
        if not head:
            return None
        intersectNode = self.get_intersect_node(head)
        if not intersectNode:
            return None
        ptr1 = head
        ptr2 = intersectNode
        while ptr1 != ptr2:
            ptr1 = ptr1.next
            ptr2 = ptr2.next
        return ptr1