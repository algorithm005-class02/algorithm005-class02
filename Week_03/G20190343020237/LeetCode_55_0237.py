#
# @lc app=leetcode.cn id=55 lang=python3
#
# [55] 跳跃游戏
#
# https://leetcode-cn.com/problems/jump-game/description/
#
# algorithms
# Medium (37.00%)
# Likes:    411
# Dislikes: 0
# Total Accepted:    49.7K
# Total Submissions: 133.2K
# Testcase Example:  '[2,3,1,1,4]'
#
# 给定一个非负整数数组，你最初位于数组的第一个位置。
#
# 数组中的每个元素代表你在该位置可以跳跃的最大长度。
#
# 判断你是否能够到达最后一个位置。
#
# 示例 1:
#
# 输入: [2,3,1,1,4]
# 输出: true
# 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
#
#
# 示例 2:
#
# 输入: [3,2,1,0,4]
# 输出: false
# 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
#
#
#

# @lc code=start

from typing import List


class Solution:
    def canJump(self, nums: List[int]) -> bool:

        # # 2019-12-28 19:50:33
        # # Time Limit Exceeded
        # # 72/75 cases passed (N/A)
        # if len(nums) == 1: return True
        # len_nums = len(nums)

        # def dfs(location):
        #     if location >= len_nums: return False
        #     if location == len_nums - 1: return True
        #     for i in range(nums[location], 0, -1):
        #         if dfs(location + i): return True
        #     return False

        # return dfs(0)

        # # # 2019-12-28 20:39:04
        # # Time Limit Exceeded
        # # 74/75 cases passed (N/A)
        # if len(nums) == 1: return True
        # len_nums = len(nums)
        # is_location_valid = [None for _ in range(len_nums)]

        # def dfs(location):
        #     if location >= len_nums: return False
        #     if location == len_nums - 1: return True
        #     if is_location_valid[location] is False: return False
        #     if is_location_valid[location] is True: return True

        #     for i in range(nums[location], 0, -1):
        #         if dfs(location + i):
        #             is_location_valid[location] = True
        #             return True

        #     is_location_valid[location] = False
        #     return False

        # return dfs(0)

        # # # 2019-12-28 20:39:04
        # # Time Limit Exceeded
        # # 74/75 cases passed (N/A)
        # if len(nums) == 1: return True
        # len_nums = len(nums)
        # is_location_valid = [None for _ in range(len_nums)]

        # def dfs(location):
        #     if location >= len_nums: return False
        #     if location == len_nums - 1: return True
        #     if is_location_valid[location] is False: return False
        #     if is_location_valid[location] is True: return True

        #     for i in range(nums[location], 0, -1):
        #         if dfs(location + i):
        #             is_location_valid[location] = True
        #             return True

        #     is_location_valid[location] = False
        #     return False

        # return dfs(0)

        # # 2019-12-28 21:03:32
        # # 找到关键位置
        # len_nums = len(nums)
        # end_reachable = len_nums - 1
        # for i in range(len_nums - 1, -1, -1):
        #     if i + nums[i] >= end_reachable:
        #         end_reachable = i

        # return end_reachable == 0

        # 2019-12-28 21:03:40
        # 要点: 如果i可以到达, 那么所有{j|j<i}也可以到达
        max_reachable = 0
        for i, n in enumerate(nums):
            if i > max_reachable: return False
            max_reachable = max(i + n, max_reachable)
            # if max_reachable >= len(nums) - 1: return True  # shortcut, 注意len(nums)本身也是O(N)

        return True


# def main():
#     s = Solution()
#     assert s.canJump([2, 0])
#     assert s.canJump([2, 0, 0])
#     assert s.canJump([3, 2, 1, 0, 4]) is False
#     assert s.canJump([2, 3, 1, 1, 4]) is True
#     assert s.canJump([2, 0, 6, 9, 8, 4, 5, 0, 8, 9, 1, 2, 9, 6, 8, 8, 0, 6, 3, 1, 2, 2, 1, 2, 6, 5, 3, 1, 2, 2, 6, 4, 2, 4, 3, 0, 0, 0, 3, 8, 2, 4, 0, 1, 2, 0, 1, 4, 6, 5, 8, 0, 7, 9, 3, 4, 6, 6, 5, 8, 9, 3, 4, 3, 7, 0, 4, 9, 0, 9, 8, 4, 3, 0, 7, 7, 1, 9, 1, 9, 4, 9, 0, 1, 9, 5, 7, 7, 1, 5, 8, 2, 8, 2, 6, 8, 2, 2, 7, 5, 1, 7, 9, 6]) is False


# if __name__ == '__main__':
#     main()

# @lc code=end
