class MyCircularDeque:

    def __init__(self, k: int):
        self.k, self.q = k, []

    def insertFront(self, value: int) -> bool:
        if len(self.q) < self.k:
            self.q.insert(0, value)
            return True
        return False

    def insertLast(self, value: int) -> bool:
        if len(self.q) < self.k:
            self.q += [value]
            return True
        return False

    def deleteFront(self) -> bool:
        return self.q.pop(0) <= float('inf') if self.q else False
    
    def deleteLast(self) -> bool:
        return self.q.pop() <= float('inf') if self.q else False
        
    def getFront(self) -> int:
        return self.q[0] if self.q else -1
    
    def getRear(self) -> int:
        return self.q[-1] if self.q else -1

    def isEmpty(self) -> bool:
        return len(self.q) == 0

    def isFull(self) -> bool:
        return len(self.q) == self.k

