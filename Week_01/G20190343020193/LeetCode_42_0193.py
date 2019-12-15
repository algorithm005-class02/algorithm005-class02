from typing import List
class Solution:
    def trap(self, height: List[int]) -> int:
        if not height: return 0
        n = len(height)
        stack = []
        res = 0
        for i in range(n):
            while stack and height[i] > height[stack[-1]]:
				tmp = stack.pop()
				if not stack: break
				res += (min(height[i], height[stack[-1]]) - height[tmp]) * (i-stack[-1] - 1)
            stack.append(i) 
        return res