# -*- encoding: utf-8 -*-
# Create on 2020/2/6

class Solution:
    def reverseBits(self, n):
        return int(str(bin(n))[2:].zfill(32)[::-1], 2)

if __name__ == '__main__':
    test = Solution()
    print(test.reverseBits(0b00000010100101000001111010011100)) #00111001011110000010100101000000
    print(test.reverseBits(0b11111111111111111111111111111101)) #10111111111111111111111111111111
