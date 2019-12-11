#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:

    # def twoSum(self, nums: List[int], target: int) -> List[int]:
    #     hash_map = {}
    #     for i,num in enumerate(nums):
    #         another_num = target - num
    #         if another_num in hash_map:
    #             return [hash_map[another_num], i]
    #         hash_map[num] = i
        # return None


    # def twoSum(self, nums: List[int], target: int) -> List[int]:    
        # for i in range(len(nums)-1):
        #     for j in range(i,len(nums)):
        #         if nums[i] + nums[j] == target and i!=j:
        #             return [i,j]

    def twoSum(self, nums: List[int], target: int) -> List[int]: 
        for i in range(len(nums)):
            if target - nums[i] in nums and nums.index(target - nums[i]) != i:
                return [i,nums.index(target-nums[i])]

# @lc code=end

