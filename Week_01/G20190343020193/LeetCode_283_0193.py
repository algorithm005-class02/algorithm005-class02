class Solution(object):
    def moveZeroes(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        zero = 0
        for i in xrange(len(nums)):
            if nums[i] != 0:
               nums[zero] = nums[i]
               if i != zero:
                   nums[i] = 0
               zero += 1