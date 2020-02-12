# -*- encoding: utf-8 -*-
# Create on 2020/2/

class Solution:
    def hammingWeight(self, n):
        res = 0
        while n != 0:
            res += 1
            n = n & (n - 1) # 清零最低位的1
        return res

if __name__ == '__main__':
    test = Solution()
    print(test.hammingWeight(0b00000000000000000000000000001011)) # 3
    print(test.hammingWeight(0b00000000000000000000000010000000)) # 1
    print(test.hammingWeight(0b00000000000000000000000000000000)) # 0
    print(test.hammingWeight(0b11111111111111111111111111111101)) # 31
    print(test.hammingWeight(0b11111111111111111111111111111111)) # 32
