# -*- encoding: utf-8 -*-
# Create on 2020/2/6

class Solution:
    def reverseBits_str(self, n):
        """28 ms"""
        """超哥说这是脱了裤子放屁的办法"""
        return int(str(bin(n))[2:].zfill(32)[::-1], 2)

    def reverseBits(self, n):
        """52 ms, 但为什么直接位运算还比较慢呢"""
        res = 0
        for _ in range(32):
            res = (res << 1) | (n & 1)
            n >>= 1
        return res



if __name__ == '__main__':
    test = Solution()
    print(test.reverseBits(0b00000010100101000001111010011100)) #964176192
    print(test.reverseBits(0b11111111111111111111111111111101)) #3221225471
