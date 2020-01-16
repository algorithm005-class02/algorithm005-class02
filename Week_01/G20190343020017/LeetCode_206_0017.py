class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        # 方法一：先将链表存为数组，然后从后往前遍历取出
        '''
        if not head:
            return head
        l = []
        while head.next:
            l.append(head)
            head = head.next
        result = head
        for node in l[::-1]:
            node.next, head.next, head = None, node, node
        return result
        '''
        # 方法二：迭代
        '''
        if not head:
            return head
        last, head, last.next = head, head.next, None
        while head:
            head.next, last, head = last, head, head.next
        return last
        '''
        # 方法三：递归
        if not head or not head.next:
            return head
        node = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return node