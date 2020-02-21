
# 给定一个无序的整数数组，找到其中最长上升子序列的长度。
#
# 示例:
#
# 输入: [10,9,2,5,3,7,101,18]
# 输出: 4
# 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
#
# 说明:
#
#
# 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
# 你算法的时间复杂度应该为 O(n2) 。
#
#
# 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
# Related Topics 二分查找 动态规划


# leetcode submit region begin(Prohibit modification and deletion)
from typing import List


class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        """
        dp[i] = dp[0..i]之间的最长上升子序列
        dp[i] = max(dp[j] + 1,dp[i]). for j in j..i-1
        :param nums:
        :return:
        """
        if not nums: return 0
        n = len(nums)
        dp = [1] * n
        for i in range(n):
            for j in range(i):
                if nums[j] < nums[i]:
                    dp[i] = max(dp[i], dp[j] + 1)
        return max(dp)

    def lengthOfLIS_NLOGN(self, nums: List[int]) -> int:
        tails, size = [0] * len(nums), 0
        for x in nums:
            i, j = 0, size
            while i != j:
                m = i + (j - i) >> 1
                if tails[m] < x:
                    i = m + 1
                else:
                    j = m
            tails[i] = x
            size = max(i + 1, size)
        return size


# leetcode submit region end(Prohibit modification and deletion)
print(Solution().lengthOfLIS([10, 9, 2, 5, 3, 7, 101, 18]))
