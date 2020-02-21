class Solution:
    def hammingWeight(self, n: int) -> int:
        n = bin(n)
        count = 0
        for i in range(2,len(n)):
            count += int(n[i])
        
        return count
        
