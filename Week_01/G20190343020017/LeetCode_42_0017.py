class Solution:
    def trap(self, height: List[int]) -> int:
        # 方法一：栈（受84题启发），也是官方题解方法三
        if not height:
            return 0
        # 栈存入下标
        stack = [0]
        result = 0
        for i in range(len(height)):
            while stack and height[stack[-1]] <= height[i]:
                last = stack.pop()
                if stack:
                    diff = min(height[i], height[stack[-1]]) - height[last]
                    result += diff * (i - stack[-1] - 1)
            stack.append(i)
        return result
        # 方法二：双指针碰撞
        l, r, lm, rm, result = 0, len(height) - 1, 0, 0, 0
        while l < r:
            if height[l] < height[r]:
                l, lm, result = l + 1, max(lm, height[l]), result + max(lm - height[l], 0)
            else:
                r, rm, result = r - 1, max(rm, height[r]), result + max(rm - height[r], 0)
        return result