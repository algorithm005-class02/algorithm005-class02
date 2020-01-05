#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 多数元素
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (60.70%)
# Likes:    391
# Dislikes: 0
# Total Accepted:    93.8K
# Total Submissions: 154.2K
# Testcase Example:  '[3,2,3]'
#
# 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
#
# 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
#
# 示例 1:
#
# 输入: [3,2,3]
# 输出: 3
#
# 示例 2:
#
# 输入: [2,2,1,1,1,2,2]
# 输出: 2
#
#
#

# @lc code=start

from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        # # O(n), O(n)
        # # 44/44 cases passed (208 ms)
        # # Your runtime beats 72.87 % of python3 submissions
        # # Your memory usage beats 97.04 % of python3 submissions (14.1 MB)
        # n2freq, len_nums = {}, len(nums)
        # for n in nums:
        #     n2freq[n] = n2freq.get(n, 0) + 1
        #     if n2freq[n] > len_nums // 2:
        #         return n

        # 排序: O(nlogn), O(n) or O(1)
        # 44/44 cases passed (192 ms)
        # Your runtime beats 94.18 % of python3 submissions
        # Your memory usage beats 98.57 % of python3 submissions (14.1 MB)
        sorted_nums = sorted(nums)
        n = len(nums)
        return sorted_nums[n // 2 + n % 2 - 1]

# @lc code=end
