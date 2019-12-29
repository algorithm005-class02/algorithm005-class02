class MyCircularDeque:
 
    def __init__(self, k):
        """
        构造函数,双端队列的大小为k。
        """
        self.item = []
        self.k = k
 
    def insertFront(self, value):
        """
        将一个元素添加到双端队列头部。 如果操作成功返回 true
        """
        if len(self.item) >= self.k:
            return False
        self.item.insert(0, value)
        return True
 
    def insertLast(self, value):
        """
        将一个元素添加到双端队列尾部。如果操作成功返回 true
        """
        if len(self.item) >= self.k:
            return False
        self.item.append(value)
        return True
 
    def deleteFront(self):
        """
        从双端队列头部删除一个元素。 如果操作成功返回 true
        """
        if len(self.item) == 0:
            return False
        self.item.pop(0)
        return True
 
    def deleteLast(self):
        """
        从双端队列尾部删除一个元素。如果操作成功返回 true。
        """
        if len(self.item) == 0:
            return False
        self.item.pop()
        return True
 
    def getFront(self):
        """
        从双端队列头部获得一个元素。如果双端队列为空，返回 -1
        """
        if len(self.item) == 0:
            return -1
        return self.item[0]
 
    def getRear(self):
        """
        获得双端队列的最后一个元素。 如果双端队列为空，返回 -1
        """
        if len(self.item) == 0:
            return -1
        return self.item[-1]
 
    def isEmpty(self):
        """
		检查双端队列是否为空	
        """
        return self.item == []
 
    def isFull(self):
        """
        检查双端队列是否满了
        """
        if len(self.item) == self.k:
            return True