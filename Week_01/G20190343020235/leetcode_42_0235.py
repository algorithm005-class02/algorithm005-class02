"""
思路 1：
暴力
直接按问题描述进行。对于数组中的每个元素，我们找出下雨后水能达到的最高位置，等于两边最大高度的较小值减去当前高度的值。
时间O(n^2) 空间 O(1)
思路 2：
动态规划
暴力的话，每次都遍历去找左右边界，我们可以提前把左右边界存起来，计算结果
时间O(n) 空间O(n)
思路 3：
利用栈
我们可以不用像方法 2 那样存储最大高度，而是用栈来跟踪可能储水的最长的条形块。使用栈就可以在一次遍历内完成计算。

我们在遍历数组时维护一个栈。如果当前的条形块小于或等于栈顶的条形块，我们将条形块的索引入栈，意思是当前的条形块被栈中的前一个条形块界定。如果我们发现一个条形块长于栈顶，我们可以确定栈顶的条形块被当前条形块和栈的前一个条形块界定，因此我们可以弹出栈顶元素并且累加答案到ans
时间O(n) 空间O(n)
思路 4：
使用双指针
可以认为如果一端有更高的条形块（例如右端），积水的高度依赖于当前方向的高度（从左到右）。当我们发现另一侧（右侧）的条形块高度不是最高的，我们则开始从相反的方向遍历（从右到左）。
我们必须在遍历时维护 \text{left\_max}left_max 和 \text{right\_max}right_max ，但是我们现在可以使用两个指针交替进行，实现 1 次遍历即可完成。
时间O(n) 空间 O(1)
"""

# 思路 1 超时
class Solution1:
    def trap(self, height: List[int]) -> int:
        height_len = len(height)
        ans = 0
        for i in range(height_len):
            max_left, max_right = 0, 0
            #左边界
            for j in range(i, -1, -1):
                max_left = max(max_left, height[j])
            #右边界
            for j in range(i, height_len):
                max_right = max(max_right, height[j])
            ans += min(max_left, max_right) - height[i]
        return ans
# 思路 2 60ms 13.2mb
class Solution2:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        height_len = len(height)
        left_maxs = [0 for i in range(height_len)]
        right_maxs = [0 for i in range(height_len)]
        left_maxs[0] = height[0]
        for i in range(1, height_len):
            left_maxs[i] = max(left_maxs[i-1], height[i])
        right_maxs[-1] = height[-1]
        for i in range(-2, -height_len-1, -1):
            right_maxs[i] = max(right_maxs[i+1], height[i])
        ans = 0
        for i in range(height_len):
            ans += min(left_maxs[i], right_maxs[i]) - height[i]
        return ans
        
# 思路 3 56ms 13.4mb
class Solution3:
    def trap(self, height: List[int]) -> int:
        height_stack = list()
        ans = 0
        height_len = len(height)
        for i in range(height_len):
            while height_stack and height[i] > height[height_stack[-1]]:
                top = height_stack[-1]
                height_stack.pop()
                if not height_stack:
                    break
                distance = i - height_stack[-1] - 1
                min_height = min(height[i], height[height_stack[-1]]) - height[top]
                ans += distance * min_height
            height_stack.append(i)
        return ans
# 思路 4 40ms 13.3mb
class Solution4:
    def trap(self, height: List[int]) -> int:
        left = 0
        right = len(height) -1
        left_max, right_max, ans = 0, 0, 0
        while left < right:
            if height[left] < height[right]:
                if height[left] > left_max:
                    left_max = height[left]
                else:
                    ans += left_max - height[left]
                left += 1
            else:
                if height[right] > right_max:
                    right_max = height[right]
                else:
                    ans += right_max - height[right]
                right -= 1
        return ans