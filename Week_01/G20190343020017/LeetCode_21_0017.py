class Solution:
    # 1.课前尝试解题（之前已经做过看过题解，不过又忘记了，重新写了一遍直接AC）
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if not l1:
            return l2
        elif not l2:
            return l1
        else:
            head = None
            if l1.val <= l2.val:
                head = l1
                l1 = head.next
            else:
                head = l2
                l2 = head.next
            head.next = self.mergeTwoLists(l1, l2)
            return head