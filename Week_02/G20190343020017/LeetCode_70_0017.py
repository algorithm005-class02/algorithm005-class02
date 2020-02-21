class Solution:
    def climbStairs(self, n: int) -> int:
        if n < 2:
            return 1
        f1, f2, f3, i = 1, 2, 2, 2
        while i < n:
            f1, f2, f3, i = f2, f1 + f2, f1 + f2, i + 1
        return f3