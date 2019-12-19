"""
这道题实际上求的是最大的面积
思路
1. 暴力
固定左边的棒子，然后遍历其右边的棒子，找到面积最大的矩形，宽为坐标之差，高度为 min(y1, y2)
2. 双指针法
从左右两边遍历，移动高度小的棒子，直到两个棒子相遇，或者左边的超过右边的，遍历结束，最后找到面积最大的矩形
"""

#暴力解法1
#超时
class Solution1:
    def maxArea(self, height: List[int]) -> int:
        num = len(height)
        num_range = range(num)
        max_area = -1
        for i in num_range:
            for j in range(i+1, num):
                area = min(height[i], height[j]) * (j-i)
                if area > max_area:
                    max_area = area
        return max_area
#暴力解法2
#依旧超时，外层的棒子如果下一个的高度比上一个低，则不用尝试
class Solution2:
    def maxArea(self, height: List[int]) -> int:
        num = len(height)
        num_range = range(num)
        max_area = -1
        for i in num_range:
            if i > 0 and height[i] <= height[i-1]:
                continue
            for j in range(i+1, num):
                area = min(height[i], height[j]) * (j-i)
                if area > max_area:
                    max_area = area
        return max_area
#双指针解法
#正确性证明：https://leetcode.com/problems/container-with-most-water/discuss/6099/Yet-another-way-to-see-what-happens-in-the-O(n)-algorithm
# cost: 132ms 14.5MB
class Solution3:
    def maxArea(self, height: List[int]) -> int:
        left, right = 0, len(height) - 1
        water = 0
        while left < right:
            water = max(water, (right-left) * min(height[left], height[right]))
            if height[left] < height[right]:
                left += 1
            else:
                right -= 1
        return water