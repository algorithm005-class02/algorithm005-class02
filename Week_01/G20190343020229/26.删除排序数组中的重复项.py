
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        idx = 0
        jdx = 1
        while idx < len(nums) and jdx < len(nums):
            if nums[idx] != nums[jdx]:
                idx = idx + 1
                nums[idx] = nums[jdx]
            jdx = jdx + 1

        return len(nums[:idx+1])
