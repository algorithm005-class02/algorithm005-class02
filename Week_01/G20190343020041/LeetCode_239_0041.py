# 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
#
# 返回滑动窗口中的最大值。
#
#
#
# 示例:
#
# 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
# 输出: [3,3,5,5,6,7]
# 解释:
#
#  滑动窗口的位置                最大值
# ---------------               -----
# [1  3  -1] -3  5  3  6  7       3
# 1 [3  -1  -3] 5  3  6  7       3
# 1  3 [-1  -3  5] 3  6  7       5
# 1  3  -1 [-3  5  3] 6  7       5
# 1  3  -1  -3 [5  3  6] 7       6
# 1  3  -1  -3  5 [3  6  7]      7
#
#
#
# 提示：
#
# 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
#
#
#
# 进阶：
#
# 你能在线性时间复杂度内解决此题吗？
# Related Topics 堆 Sliding Window


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List
from collections import deque


class Solution:
    def maxSlidingWindow(self, nums: List[int], k: int) -> List[int]:
        res = []
        d = deque()
        for i in range(len(nums)):
            # 如果之前最大值已经不在滑动窗口中，则移除
            while d and d[0] < i - k + 1:
                d.popleft()
            while d and nums[d[-1]] < nums[i]:
                d.pop()
            d.append(i)
            if i >= k - 1:
                res.append(nums[d[0]])
        return res


# leetcode submit region end(Prohibit modification and deletion)
Solution().maxSlidingWindow([1, 3, -1, -3, 5, 3, 6, 7], 3)
