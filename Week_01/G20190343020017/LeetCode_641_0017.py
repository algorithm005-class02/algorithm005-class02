# 双向链表实现双端队列，运行时间84ms

class DequeNode:
    def __init__(self, value: int):
        self.val = value
        self.next = None
        self.prev = None

class MyCircularDeque:

    def __init__(self, k: int):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        """
        self.size = k
        self.head = None
        self.last = None
        self.count = 0

    def insertFront(self, value: int) -> bool:
        """
        Adds an item at the front of Deque. Return True if the operation is successful.
        """
        if self.isFull():
            return False
        head = DequeNode(value)
        head.next = self.head
        if self.head:
            self.head.prev = head
        self.head = head
        self.count += 1
        if not self.last:
            self.last = head
        return True

    def insertLast(self, value: int) -> bool:
        """
        Adds an item at the rear of Deque. Return True if the operation is successful.
        """
        if self.isFull():
            return False
        last = DequeNode(value)
        last.prev = self.last
        if self.last:
            self.last.next = last
        self.last = last        
        self.count += 1
        if not self.head:
            self.head = last
        return True

    def deleteFront(self) -> bool:
        """
        Deletes an item from the front of Deque. Return True if the operation is successful.
        """
        if self.isEmpty():
            return False
        self.head = self.head.next
        if self.head:
            self.head.prev = None
        else:
            self.last = None
        self.count -= 1
        return True

    def deleteLast(self) -> bool:
        """
        Deletes an item from the rear of Deque. Return True if the operation is successful.
        """
        if self.isEmpty():
            return False
        self.last = self.last.prev
        if self.last:
            self.last.next = None
        else:
            self.head = None
        self.count -= 1
        return True

    def getFront(self) -> int:
        """
        Get the front item from the deque.
        """
        return -1 if not self.head else self.head.val

    def getRear(self) -> int:
        """
        Get the last item from the deque.
        """
        return -1 if not self.last else self.last.val

    def isEmpty(self) -> bool:
        """
        Checks whether the circular deque is empty or not.
        """
        return self.count == 0

    def isFull(self) -> bool:
        """
        Checks whether the circular deque is full or not.
        """
        return self.count == self.size
        


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