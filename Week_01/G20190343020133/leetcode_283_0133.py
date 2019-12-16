class Solution(object):
    def moveZeroes(self, nums: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        i = 0
        for j in range(len(nums)):
            if nums[j] != 0:
                if i != j:
                    nums[i] = nums[j]
                    nums[j] = 0
                i += 1