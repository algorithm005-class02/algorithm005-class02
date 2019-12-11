#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        
        # for i in range(len(nums)-1,0,-1):
        #     if nums[i] == nums[i-1]:
        #         nums.pop(i)
        # return len(nums)
        j = 0
        for i in range(len(nums)-1):
            if nums[i] == nums[j]:
                nums[j] = nums[i]
                j += 1
        return nums

# @lc code=end

