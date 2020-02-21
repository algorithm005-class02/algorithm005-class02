class Solution:
    def hammingWeight(self, n: int) -> int:
        count = 0
        while n:
            count += n&1
            n >>= 1
        return count
    
    def hammingWeight1(self, n: int) -> int:
        bin(n).count('1')