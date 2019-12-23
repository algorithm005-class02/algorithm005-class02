class Solution:
    # 方法一：暴力法，测试代码没问题，提交超时
    '''
    def largestRectangleArea(self, heights: List[int]) -> int:
        if not heights:
            return 0
        maxArea = 0
        for i in range(len(heights)):
            minHeight = None
            for j in range(i, len(heights)):
                minHeight = heights[j] if minHeight is None else min(minHeight, heights[j])
                maxArea = max(maxArea, minHeight * (j - i + 1))
        return maxArea
    '''
    # 方法二：栈
    def largestRectangleArea(self, heights: List[int]) -> int:
        stack = [-1]
        maxArea = 0
        for i in range(len(heights)):
            while stack[-1] != -1 and heights[i] < heights[stack[-1]]:
                maxArea = max(maxArea, heights[stack.pop()] * (i - stack[-1] - 1))
            stack.append(i)    
        while stack[-1] != -1:
            maxArea = max(maxArea, heights[stack.pop()] * (len(heights) - stack[-1] - 1))
        return maxArea