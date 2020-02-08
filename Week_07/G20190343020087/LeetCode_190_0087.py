class Solution:
    def reverseBits(self, n: int) -> int:

        rev_bits = 0
        for i in range(32):

            rev_bits = rev_bits << 1

            rev_bits = rev_bits | (n & 1)

            n = n >> 1

        return rev_bits
