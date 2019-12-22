#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # V1 暴力方法
        # 两层循环，遍历数组求和
        # 复杂度为 O(n^2)
        for i in range(0, len(nums)-1):
            x = nums[i]
            for j in range(i+1, len(nums)):
                y = nums[j]
                _sum = x + y
                if _sum == target:
                    return [i, j]


        # V2 哈希表
        
# @lc code=end

