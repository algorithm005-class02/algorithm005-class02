class Solution:
  def reverseBits(self, n: int) -> int:
    result = 0
    for i in range(32):
      result = result | (((n >> (31 - i)) & 1) << i)
    return result
