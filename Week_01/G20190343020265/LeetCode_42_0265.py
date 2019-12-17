#
# @lc app=leetcode.cn id=42 lang=python3
#
# [42] 接雨水
#

# @lc code=start
# 双指针夹逼解法，根据题意，这里有两个关键点
# ，第一是只需左右的柱子群体里各有一个柱子高于当前柱子，即可存储雨水
# ，第二是左右的柱子群体中，只需要任意一个柱子较高即可，不管index的位置
# ，通过设立左右两个指针，分别指向左右高柱子，当左柱子小于右柱子，雨水高度取决于左柱子
# ，因为这时候右边柱子群是一定可以帮助存储雨水的，不用担心遍历是刚开始，不需要接触到所有柱子
# ，同理，当右柱子小于左柱子，右柱子决定雨水高度（本身柱子很高，那就存不了水）
# ，两边往中间夹逼，最终遍历结束得到汇总结果。
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height or len(height) < 3:
            return 0
        res = 0
        left, right = 0, len(height) - 1
        l_max, r_max = height[left], height[right]
        while left < right:
            l_max, r_max = max(l_max, height[left]), max(r_max, height[right])
            if l_max <= r_max:
                res += l_max - height[left]
                left += 1
            else:
                res += r_max - height[right]
                right -= 1
        return res

# @lc code=end

