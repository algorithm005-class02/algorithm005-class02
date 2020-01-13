学习笔记

数组：
如何实现随机访问？ 连续的内存空间，存放一组相同类型的数据

低效的插入和删除
数组不做其他优化操作时，删除和插入需要做群移操作，所以时间复杂度时 O(n)

警惕数组越界：做好越界检查

容器(collections)能否完全代替数组：
平时业务开发使用编程语言提供的collections，比如java的ArrayList等，底层开发直接使用数组更合适

下标确切的说法应该叫偏移（offset），
一维数组寻址公式：
```bash
a[k]_address = base_address + k * type_size
```
二维数组寻址公式：
对于m*n的数组，a[i][j]，其中(i < m， j < n)的地址为：
```bash
a[i][j]_address = base_address + (i * n + j) * type_size
```


链表：经典应用 -> LRU缓存淘汰算法
缓存：提高数据读取性能，cpu缓存，数据库缓存，浏览器缓存。。。
缓存淘汰策略：FIFO（先进先出），LFU（最少使用），LRU（最近最少使用）
不需要连续空间，通过指针将零散的内存空间串联起来使用

单向链表，双向链表，循环链表
空间换时间

如何使用链表实现LRU算法：
思路：维护一个有序单链表，越靠近链表尾部的节点是越早之前被访问。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表
1.如果此数据之前已经被缓存在链表中，我们遍历得到这个数据对应的节点，并将其从原来的位置删除，然后再插入到链表头部
2.如果没有此数据在链表中，又可以分为两种情况
    2.1 如果此时缓存已满，则将链表尾部节点删除，将新的节点插入到建表头部
    2.2 如果此时缓存未满，则将节点直接插入到链表头部
同时，可以引入散列表（hash table），用来记录链表中节点存放的位置，可以O(n)的时间复杂度降至O(1)

链表代码编写技巧：
技巧一：理解指针或引用的含义
技巧二：警惕指针丢失和内存泄漏
技巧三：利用哨兵，简化实现难度（插入排序，归并排序，动态规划等）
技巧四：重点留意边界条件处理
技巧五：举例画图，辅助思考
技巧六：多写多练，没有捷径

leetCode_206_反转单链表：
双指针迭代
```python
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        prev,cur = None,head
        while cur:
            cur.next,prev,cur = prev,cur,cur.next
        return prev
```

递归
```python
class ListNode:
    def __init__(sekf, x):
        self.val = x
        self.next = None
class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        return self._reverse(head)
    def _reverse(self,node,prev=None):
        if not node:
            return prev
        n = node.next
        node.next = prev
        return self._reverse(n,node)
```

leetCode_141_链表中环的检测：
利用set求解
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        s = set()
        while head:
            if head in s:
                return True
            s.add(head)
            head = head.next
        return False
```

快慢指针，也可以叫龟兔赛跑
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        try:
            slow = head
            fast = head.next
            while slow not in fast:
                slow = head.next
                fast = head.next.next
            return True
        except:
            return False
```

leetCode_21_两个有序链表合并
```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if l1 and l2:
            if l1.val > l2.val: l1,l2 = l2,l1
            l1.next = self.mergeTwoLists(l1.next,l2)
        return l1 or l2
```

```python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def mergeTwoLists(self, a: ListNode, b: ListNode) -> ListNode:
        if not a or b and a.val > b.val:
            a,b = b,a
        if a:
            a.next = self.mergeTwoLists(a.next,b)
        return a
```

leetCode 删除链表中倒数第n个结点

leetCode 求链表的中间节点 