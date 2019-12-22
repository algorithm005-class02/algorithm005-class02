class MyCircularDeque(object):

    def __init__(self, k):
        """
        Initialize your data structure here. Set the size of the deque to be k.
        :type k: int
        """
        self._length = k
        self.circular_deque = []


    def insertFront(self, value):
        """
        Adds an item at the front of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if len(self.circular_deque) >= self._length:
            return False
        if isinstance(value, int):
            self.circular_deque.insert(0, value)
            return True
        else:
            return False


    def insertLast(self, value):
        """
        Adds an item at the rear of Deque. Return true if the operation is successful.
        :type value: int
        :rtype: bool
        """
        if len(self.circular_deque) >= self._length:
            return False
        if isinstance(value, int):
            self.circular_deque.append(value)
            return True
        else:
            return False

    def deleteFront(self):
        """
        Deletes an item from the front of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if len(self.circular_deque) == 0:
            return False
        else:
            self.circular_deque.pop(0)
            return True


    def deleteLast(self):
        """
        Deletes an item from the rear of Deque. Return true if the operation is successful.
        :rtype: bool
        """
        if len(self.circular_deque) == 0:
            return False
        else:
            self.circular_deque.pop()
            return True

    def getFront(self):
        """
        Get the front item from the deque.
        :rtype: int
        """
        if len(self.circular_deque) > 0:
            return self.circular_deque[0]
        else:
            return -1

    def getRear(self):
        """
        Get the last item from the deque.
        :rtype: int
        """
        if len(self.circular_deque) > 0:
            return self.circular_deque[-1]
        else:
            return -1

    def isEmpty(self):
        """
        Checks whether the circular deque is empty or not.
        :rtype: bool
        """
        if len(self.circular_deque) == 0:
            return True
        else:
            return False

    def isFull(self):
        """
        Checks whether the circular deque is full or not.
        :rtype: bool
        """
        if len(self.circular_deque) == self._length:
            return True
        else:
            return False

if __name__ == "__main__":
    test_deque = MyCircularDeque(4)
    print(test_deque.insertFront(9))
    print(test_deque.deleteLast())
    print(test_deque.getRear())
    print((test_deque.getFront()))
    print((test_deque.getFront()))
    print(test_deque.deleteFront())
    print(test_deque.insertFront(6))
    print(test_deque.insertLast(5))
    print(test_deque.insertFront(9))
    print((test_deque.getFront()))
    print(test_deque.insertFront(6))

