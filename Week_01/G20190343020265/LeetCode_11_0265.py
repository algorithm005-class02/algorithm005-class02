#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
# 解法一，暴力破解法
# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#         max_value = 0
#         for i in range(len(height)):
#             for j in range(len(height)-i-1):
#                 area = (j+1) * min(height[i+j+1], height[i])
#                 max_value = max(area, max_value)
#         return max_value

# 解法二，双指针夹逼解法
# class Solution:
#     def maxArea(self, height: List[int]) -> int:
#         max_value = 0
#         left = 0
#         right = len(height) - 1
#         while left < right:
#             max_area = min(height[left], height[right]) * (right - left)
#             max_value = max(max_value, max_area)
#             if height[left] < height[right]:
#                 left += 1
#             else:
#                 right -= 1

#         return max_value

# 解法二的网络最优solution
class Solution:
    def maxArea(self, height: List[int]) -> int:
        L, R, width, res = 0, len(height) - 1, len(height) - 1, 0
        for w in range(width, 0, -1):
            if height[L] < height[R]:
                res, L = max(res, height[L] * w), L + 1
            else:
                res, R = max(res, height[R] * w), R - 1
        return res


# @lc code=end

