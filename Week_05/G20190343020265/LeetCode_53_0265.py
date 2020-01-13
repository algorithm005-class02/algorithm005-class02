#
# @lc app=leetcode.cn id=53 lang=python3
#
# [53] 最大子序和
#

# @lc code=start
class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        if not nums:
            return 0
        cursum = maxsum = nums[0]
        for i in nums[1:]:
            cursum = max(i, cursum + i)
            maxsum = max(maxsum, cursum)
        return maxsum

        
# @lc code=end

