#
# @lc app=leetcode.cn id=11 lang=python3
#
# [11] 盛最多水的容器
#

# @lc code=start
class Solution:
    #双指针夹逼操作
    def maxArea(self, height: List[int]) -> int:
        i, j = 0, len(height)-1
        area = 0
        while i < j:
            area = max(area,(j - i) * min(height[i], height[j]))
            if height[i] < height[j]:
                i += 1
            else:
                j -= 1
        return area

'''
    #暴力法求解
    # def maxArea(self, height: List[int]) -> int:
    #     area = 0
    #     for i in range(len(height)-1):
    #         for j in range(i,len(height)):
    #             area = max(area,(j - i) * min(height[i], height[j]))
    #     return area
'''  
     
# @lc code=end