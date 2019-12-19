from typing import List

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache = {}
        for i, n in enumerate(nums):
            diff = target - n
            if diff in cache:
                return [cache[diff], i]
            cache[n] = i

