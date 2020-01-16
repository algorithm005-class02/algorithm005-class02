"""
思路 1:
双指针 
时间 O(n)空间O(1)
"""

#思路 1 84ms 14.5mb
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        i = 0
        nums_len = len(nums)
        for j in range(nums_len):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i+1