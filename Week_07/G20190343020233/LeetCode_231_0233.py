# -*- encoding: utf-8 -*-
# Create on 2020/2/6

class Solution:
    def isPowerOfTwo(self, n):
        return (n != 0) and (n & (n -1) == 0)

if __name__ == '__main__':
    test = Solution()
    print(test.isPowerOfTwo(1)) # True
    print(test.isPowerOfTwo(16)) # True
    print(test.isPowerOfTwo(218)) # False
