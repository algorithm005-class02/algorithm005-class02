#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# @lc code=start
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        res = []
        for i in range(len(nums)-2):
            for j in range(i,len(nums)-1):
                for k in range(j,len(nums)):
                    if nums[i] + nums[j] + nums[k] ==0:
                        res.extend(nums[i], nums[j], nums[k])
        return res
# @lc code=end

