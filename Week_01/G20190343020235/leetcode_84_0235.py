"""
思路 1
暴力
两个柱子间矩形的高由它们之间最矮的柱子决定
因此，我们可以考虑所有两两柱子之间形成的矩形面积，该矩形的高为它们之间最矮柱子的高度，宽为它们之间的距离，这样可以找到所要求的最大面积的矩形。
时间: O(n^3) 空间 O(1)
思路 2
优化的暴力
不用循环一遍找最小的高度，用前一对柱子间的最小高度，找到当前这一对柱子的最小高度
时间: O(n^2) 空间 O(1)
思路 3

思路 4

思路 5
栈，单调栈，栈中存下标
如果当前柱子的高度比栈顶的柱子高度要矮，则出栈，计算面积
遍历完后如果栈不为空，则清理栈，右侧的柱子一定比栈顶的柱子要高
时间：O(n) 空间 O(n)
"""

# 思路 1 超时
class Solution1:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        max_area = -1
        int_max = 1 << 64 - 1
        for i in range(n):
            for j in range(i, n):
                min_height = int_max
                for k in range(i, j+1):
                    min_height = min(min_height, heights[k])
                max_area = max(max_area, (j-i+1)*min_height)
        return max_area

# 思路 2 超时
class Solution2:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        max_area = 0
        int_max = 1 << 64 - 1

        for i in range(n):
            min_height = int_max

            for j in range(i, n):
                min_height = min(min_height, heights[j])
                max_area = max(max_area, (j-i+1)*min_height)
        return max_area
            

# 思路 3

# 思路 4

# 思路 5 104ms 14.3mb
class Solution5:
    def largestRectangleArea(self, heights: List[int]) -> int:
        n = len(heights)
        max_area = 0
        stack = []
        for i in range(n):
            while stack and heights[stack[-1]] >= heights[i]:
                height = heights[stack[-1]]
                stack.pop()
                left_bound = -1 if not stack else stack[-1]
                max_area = max(max_area, height * (i-left_bound-1))
            stack.append(i)
        while stack:
            height = heights[stack[-1]]
            stack.pop()
            left_bound = -1 if not stack else stack[-1]
            max_area = max(max_area, height * (n-left_bound-1))
        return max_area