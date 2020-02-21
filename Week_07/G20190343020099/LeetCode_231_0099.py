class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return 0;
        return n & (-n) == n