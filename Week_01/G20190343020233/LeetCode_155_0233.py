class MinStack:

    """
    1。 直接用列表 (leetcode已提交, 这种耗时较高主要是因为没有存最小值)
    2。 用链表 (leetcode已提交)
    3。 用tuple列表
    """

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.stack = []

    def push(self, x: int) -> None:
        if self.stack == []:
            self.stack.append((x, x))
        else:
            self.stack.append((x, min(x, self.stack[-1][1])))

    def pop(self) -> None:
        self.stack.pop()

    def top(self) -> int:
        return self.stack[-1][0]

    def getMin(self) -> int:
        return self.stack[-1][1]