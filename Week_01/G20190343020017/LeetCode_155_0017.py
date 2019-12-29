# 方法一：push 和 pop 时记录最小值，getMin 直接返回（80-84ms，超过60%）
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.min = None

    def push(self, x: int) -> None:
        self.data.append(x)
        self.min = x if self.min is None else min(self.min, x)

    def pop(self) -> None:
        self.data.pop()
        temp = sorted(self.data)
        self.min = temp[0] if temp else None

    def top(self) -> int:
        return self.data[-1]

    def getMin(self) -> int:
        return self.min
# 方法二：参考题解辅助栈方法
class MinStack:

    def __init__(self):
        """
        initialize your data structure here.
        """
        self.data = []
        self.minstack = []

    def push(self, x: int) -> None:
        self.data.append(x)
        self.minstack.append(self.minstack[-1] if self.minstack and self.minstack[-1] < x else x)

    def pop(self) -> None:
        self.data.pop()
        self.minstack.pop()

    def top(self) -> int:
        return self.data[-1]

    def getMin(self) -> int:
        return self.minstack[-1]