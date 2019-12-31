# 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
#
#
#
# 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
#
# 示例:
#
# 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
# 输出: 6
# Related Topics 栈 数组 双指针


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:

    def trap(self, height: List[int]) -> int:
        if not height:
            return 0
        res = 0
        n = len(height)

        stack = []
        current = 0
        while current < n:
            while stack and height[current] > height[stack[-1]]:
                h = height[stack[-1]]
                stack.pop()
                if not stack:
                    break
                distance = current - stack[-1] - 1
                min_height = min(height[stack[-1]], height[current])
                res += distance * (min_height - h)
            stack.append(current)
            current += 1

        return res

    def trap2P(self, height: List[int]) -> int:
        """
        double points
        :param height:
        :return:
        """
        if not height:
            return 0
        res = 0
        n = len(height)

        left, right = 0, n - 1
        left_max, right_max = height[0], height[n - 1]

        while left < right:
            if left_max < right_max:
                res += left_max - height[left]
                left += 1
                left_max = max(left_max, height[left])
            else:
                res += right_max - height[right]
                right -= 1
                right_max = max(right_max, height[right])

        return res

    def trapDP(self, height: List[int]) -> int:
        """
        动态规划
        :param height:
        :return:
        """
        if not height:
            return 0
        res = 0
        n = len(height)
        left_max = [0] * n
        right_max = [0] * n
        left_max[0] = height[0]
        for i in range(1, n):
            left_max[i] = max(left_max[i - 1], height[i])
        right_max[n - 1] = height[n - 1]
        for i in range(n - 2, 0, -1):
            right_max[i] = max(right_max[i + 1], height[i])

        for i in range(1, n - 1):
            res += min(left_max[i], right_max[i]) - height[i]

        return res

    def trapBruteForce(self, height: List[int]) -> int:
        """
        暴力
        :param height:
        :return:
        """
        res = 0
        n = len(height)
        for i in range(1, n - 1):
            max_left = max_right = 0
            for j in range(i, 0, -1):
                max_left = max(max_left, height[j])
            for j in range(i, n):
                max_right = max(max_right, height[j])
            res += min(max_left, max_right) - height[i]

        return res


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().trap([0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]))
