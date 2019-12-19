class Solution:
    def moveZeroes(self, nums):
        """
        Do not return anything, modify nums in-place instead.
        """
        flag_zero = 0
        for i in range(len(nums)):
            # if nums[i] != 0:
            #     nums[flag_zero] = nums[i]
            #     if i != flag_zero:
            #         nums[i] = 0
            #     flag_zero += 1
            if nums[i] != 0:
                nums[flag_zero], nums[i] = nums[i], nums[flag_zero]
                # if i != flag_zero:
                #     nums[i] = 0
                flag_zero += 1