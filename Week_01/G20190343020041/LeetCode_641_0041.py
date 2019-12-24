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
# getRear()：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1。
# isEmpty()：检查双端队列是否为空。
# isFull()：检查双端队列是否满了。
#
#
# 示例：
#

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
# Related Topics 设计 队列
import unittest


# leetcode submit region begin(Prohibit modification and deletion)
class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self.front = 0
        self.rear = 0
        self.capacity = k + 1
        self.arr = [-1] * self.capacity

    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.arr[self.front] = value
        self.front = (self.front - 1 + self.capacity) % self.capacity
        return True

    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if self.isFull():
            return False
        self.rear = (self.rear + 1) % self.capacity
        self.arr[self.rear] = value
        return True

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.front = (self.front + 1) % self.capacity
        return True

    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if self.isEmpty():
            return False
        self.rear = (self.rear - 1 + self.capacity) % self.capacity
        return True

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.arr[(self.front + 1) % self.capacity]

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if self.isEmpty():
            return -1
        return self.arr[self.rear]

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        return self.rear == self.front

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        return (self.front - 1 + self.capacity) % self.capacity == self.rear


# Your MyCircularDeque object will be instantiated and called as such:


# leetcode submit region end(Prohibit modification and deletion)
class TestDict(unittest.TestCase):
    def test_success(self):
        circularDeque = MyCircularDeque(3);
        self.assertTrue(circularDeque.insertFront(1))
        self.assertTrue(circularDeque.insertLast(2))
        self.assertTrue(circularDeque.insertFront(3))
        self.assertFalse(circularDeque.insertFront(4))
        self.assertEqual(circularDeque.getRear(), 2)
        self.assertTrue(circularDeque.isFull())
        self.assertTrue(circularDeque.deleteLast())
        self.assertEqual(circularDeque.getFront(), 4)


if __name__ == "__main__":
    unittest.main()
