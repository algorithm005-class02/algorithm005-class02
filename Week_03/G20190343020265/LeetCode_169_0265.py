#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#

# @lc code=start

# 解法一，暴力解法
# class Solution:
#     def majorityElement(self, nums: List[int]) -> int:
#         mid_count = len(nums) // 2
#         for i in nums:
#             temp = sum(1 for j in nums if j == i)
#             if temp > mid_count:
#                 return i

# 解法二，哈希表解法
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        counts = collections.Counter(nums)
        return max(counts.keys(), key = counts.get)   


# @lc code=end

