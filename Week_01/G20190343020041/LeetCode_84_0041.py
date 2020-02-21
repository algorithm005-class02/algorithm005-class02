# 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
#
# 求在该柱状图中，能够勾勒出来的矩形的最大面积。
#
#
#
#
#
# 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
#
#
#
#
#
# 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
#
#
#
# 示例:
#
# 输入: [2,1,5,6,2,3]
# 输出: 10
# Related Topics 栈 数组

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
class Solution:
    def largestRectangleArea(self, heights: List[int]) -> int:
        heights.append(0)
        area = 0
        stack = [-1]
        for i in range(len(heights)):
            while heights[i] < heights[stack[-1]]:
                h = heights[stack.pop()]
                w = i - stack[-1] - 1
                area = max(h * w, area)
            stack.append(i)
        heights.pop()
        return area


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().largestRectangleArea([2, 1, 5, 6, 2, 3]))
