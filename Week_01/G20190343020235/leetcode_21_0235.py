"""
思路1：
递归：两个链表头部较小的一个与剩下元素的 merge 操作
边界条件：l1 为空 返回 l2 l2 为空返回l1

思路2：
迭代: 都是有序链表，加一个 prev 指针，表明当前的位置，然后比较 l1, l2 的大小，重新构建链表
"""

#思路 1  32ms 12.7mb
class Solution1:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        if not l2:
            return l1
        if l1.val < l2.val:
            l1.next = self.mergeTwoLists(l1.next, l2)
            return l1
        if l1.val >= l2.val:
            l2.next = self.mergeTwoLists(l1, l2.next)
            return l2
#思路 2 24ms 12.7mb
class Solution2:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        sentinel = ListNode(-1)
        prev = sentinel
        
        while l1 and l2:
            if l1.val < l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next
        prev.next = l1 if l1 else l2
        return sentinel.next 