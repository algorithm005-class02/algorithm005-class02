"""
思路 1
迭代
1->2->3->4->null 反转成 null<-1<-2<-3<-4
需要三个节点，prev， cur， next prev 需要把 cur.next 指向 prev, 并且用 next 记录下 cur.next,保证能遍历完整个链表
时间 O(n) 空间 O(1)
思路 2
递归
假设目前有已经反转到第 k 可节点了， n1->n2->...->nk->nk+1<-.....<-null
那么要反转第 k 个节点，需要做的就是 nk.next.next = nk
时间 O(n) 空间 O(n)
"""
#思路 1 32ms 13.mb
class Solution1:
    def reverseList(self, head: ListNode) -> ListNode:
        prev = None
        cur = head
        while cur:
            tmp_next = cur.next
            cur.next = prev
            prev = cur
            cur = tmp_next
        return prev

#思路 2 32ms 17.3mb
class Solution2:
    def reverseList(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        p = self.reverseList(head.next)
        head.next.next = head
        head.next = None
        return p
        