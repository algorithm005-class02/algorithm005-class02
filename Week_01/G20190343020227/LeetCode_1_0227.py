class Solution(object):
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        data = {}
        for i in range(len(nums)):
            n = target - nums[i]
            if n in data:
                return [data[n],i]
            else:
                data[nums[i]] = i