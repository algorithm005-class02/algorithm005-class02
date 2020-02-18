from typing import List

class Solution:
  def lengthOfLIS(self, nums: List[int]) -> int:
    tails = [0] * len(nums)
    size = 0
    for num in nums:
      i, j = 0, size
      while i != j:
        m = (i + j) // 2
        if tails[m] < num:
          i = m + 1
        else:
          j = m
      tails[i] = num
      size = max(size, i + 1)
    return size


nums = [10,9,2,5,3,7,101,18,4]
s = Solution()
result = s.lengthOfLIS(nums)
print(result)
