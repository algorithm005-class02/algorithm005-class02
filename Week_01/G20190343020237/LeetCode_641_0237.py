#
# @lc app=leetcode.cn id=641 lang=python3
#
# [641] 设计循环双端队列
#
# https://leetcode-cn.com/problems/design-circular-deque/description/
#
# algorithms
# Medium (48.04%)
# Likes:    20
# Dislikes: 0
# Total Accepted:    3.4K
# Total Submissions: 7.1K
# Testcase Example:  '["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]\n' + '[[3],[1],[2],[3],[4],[],[],[],[4],[]]'
#
# 设计实现双端队列。
# 你的实现需要支持以下操作：
#
#
# MyCircularDeque(k)：构造函数,双端队列的大小为k。
# insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true。
# insertLast()：将一个元素添加到双端队列尾部。如果操作成功返回 true。
# deleteFront()：从双端队列头部删除一个元素。 如果操作成功返回 true。
# deleteLast()：从双端队列尾部删除一个元素。如果操作成功返回 true。
# getFront()：从双端队列头部获得一个元素。如果双端队列为空，返回 -1。
# getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
# isEmpty()：检查双端队列是否为空。
# isFull()：检查双端队列是否满了。
#
#
# 示例：
#
# MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
# circularDeque.insertLast(1);                    // 返回 true
# circularDeque.insertLast(2);                    // 返回 true
# circularDeque.insertFront(3);                    // 返回 true
# circularDeque.insertFront(4);                    // 已经满了，返回 false
# circularDeque.getRear();                  // 返回 2
# circularDeque.isFull();                        // 返回 true
# circularDeque.deleteLast();                    // 返回 true
# circularDeque.insertFront(4);                    // 返回 true
# circularDeque.getFront();                // 返回 4
#
#
#
#
# 提示：
#
#
# 所有值的范围为 [1, 1000]
# 操作次数的范围为 [1, 1000]
# 请不要使用内置的双端队列库。
#
#
#

# @lc code=start


# class MyCircularDeque:

#     def __init__(self, k: int):
#         """
#         Initialize your data structure here. Set the size of the deque to be k.
#         """
#         self.q = [None for _ in range(k)]
#         self.head, self.tail = None, None
#         self.k = k

#     def insertFront(self, value: int) -> bool:
#         """
#         Adds an item at the front of Deque. Return true if the operation is successful.
#         """

#         if self.head is None:
#             self.head, self.tail = 0, 0
#             self.q[self.head] = value
#             return True

#         i_head = (self.head-1) % self.k
#         if i_head != self.tail:  # not full
#             self.q[i_head] = value
#             self.head = i_head
#             return True

#         return False

#     def insertLast(self, value: int) -> bool:
#         """
#         Adds an item at the rear of Deque. Return true if the operation is successful.
#         """

#         if self.tail is None:
#             self.head, self.tail = 0, 0
#             self.q[self.tail] = value
#             return True

#         i_tail = (self.tail+1) % self.k
#         if i_tail != self.head:  # not full
#             self.q[i_tail] = value
#             self.tail = i_tail
#             return True
#         return False

#     def deleteFront(self) -> bool:
#         """
#         Deletes an item from the front of Deque. Return true if the operation is successful.
#         """
#         if self.head is None:
#             return False

#         if self.head == self.tail:
#             self.head, self.tail = None, None
#         else:
#             self.head = (self.head+1) % self.k

#         return True

#     def deleteLast(self) -> bool:
#         """
#         Deletes an item from the rear of Deque. Return true if the operation is successful.
#         """
#         if self.tail is None:
#             return False

#         if self.tail == self.head:
#             self.head, self.tail = None, None
#         else:
#             self.tail = (self.tail-1) % self.k
#         return True

#     def getFront(self) -> int:
#         """
#         Get the front item from the deque.
#         """
#         if self.head is None:
#             return -1

#         return self.q[self.head]

#     def getRear(self) -> int:
#         """
#         Get the last item from the deque.
#         """
#         if self.tail is None:
#             return -1

#         return self.q[self.tail]

#     def isEmpty(self) -> bool:
#         """
#         Checks whether the circular deque is empty or not.
#         """
#         return self.head is None

#     def isFull(self) -> bool:
#         """
#         Checks whether the circular deque is full or not.
#         """
#         if self.isEmpty():      # 边界判断
#             return False

#         return (self.tail+1) % self.k == self.head

# 2019-12-14 20:04:29
# space: O(k+1), 浪费一个元素来区分empty和full
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.q = [None for _ in range(k+1)]    # 牺牲一个结点来: head==tail => empty; tail+1==heat => full
        self.head, self.tail = 0, 0  # [head, tail)
        self.k = k+1

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False

        i_head = (self.head-1) % self.k
        self.q[i_head] = value
        self.head = i_head
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if self.isFull():
            return False

        i_tail = (self.tail+1) % self.k
        self.q[i_tail-1] = value
        self.tail = i_tail
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False

        self.head = (self.head+1) % self.k
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        if self.isEmpty():
            return False

        self.tail = (self.tail-1) % self.k
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        if self.isEmpty():
            return -1

        return self.q[self.head]

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        if self.isEmpty():
            return -1

        return self.q[(self.tail-1) % self.k]

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.head == self.tail

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return (self.tail+1) % self.k == self.head


# Your MyCircularDeque object will be instantiated and called as such:
# obj = MyCircularDeque(k)
# param_1 = obj.insertFront(value)
# param_2 = obj.insertLast(value)
# param_3 = obj.deleteFront()
# param_4 = obj.deleteLast()
# param_5 = obj.getFront()
# param_6 = obj.getRear()
# param_7 = obj.isEmpty()
# param_8 = obj.isFull()
# @lc code=end
