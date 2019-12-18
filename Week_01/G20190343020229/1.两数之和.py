#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        v_map = {}
        for idx, i in enumerate(nums):
            # print(v_map)
            if i in v_map:
                return [v_map[i], idx]
            else:
                left = target - i
                v_map[left] = idx
        return []

# @lc code=end

