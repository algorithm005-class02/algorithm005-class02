#
# @lc app=leetcode.cn id=641 lang=python3
#
# [641] 设计循环双端队列
#

# @lc code=start
class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.k, self.q = k, []

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        """
        if len(self.q) < self.k:
            self.q.insert(0, value)
            return True
        return False

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        """
        if len(self.q) < self.k:
            self.q += [value]
            return True
        return False
    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        """
        return self.q.pop(0) <= float('inf') if self.q else False

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        """
        return self.q.pop() <= float('inf') if self.q else False

    def getFront(self) -> int: 
        """
        Get the front item from the deque.
        """
        return self.q[0] if self.q else -1

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return self.q[-1] if self.q else -1

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return len(self.q) == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return len(self.q) == self.k
        


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

