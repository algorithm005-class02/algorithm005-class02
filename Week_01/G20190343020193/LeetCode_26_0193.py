class Solution(object):
    def removeDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        if len(nums) <= 1:
            return len(nums)
            
        k = 1
        while(k < len(nums)):
            if nums[k] == nums[k-1]:
                del nums[k]
            else:
                k += 1
        return k