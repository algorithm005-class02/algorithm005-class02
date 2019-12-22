#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#
# https://leetcode-cn.com/problems/two-sum/description/
#
# algorithms
# Easy (47.08%)
# Likes:    7103
# Dislikes: 0
# Total Accepted:    718K
# Total Submissions: 1.5M
# Testcase Example:  '[2,7,11,15]\n9'
#
# 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
#
# 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
#
# 示例:
#
# 给定 nums = [2, 7, 11, 15], target = 9
#
# 因为 nums[0] + nums[1] = 2 + 7 = 9
# 所以返回 [0, 1]
#
#
#

# @lc code=start


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # # 枚举: O(n^2), O(1)
        # for i in range(len(nums)):
        #     for j in range(i+1, len(nums)):
        #         if nums[i]+nums[j] == target:
        #             return [i, j]
        # return []

        # # 双指针：O(nlogn)+O(n)=O(nlogn), O(n)
        # # 29/29 cases passed (52 ms)
        # # Your runtime beats 99.01 % of python3 submissions
        # # Your memory usage beats 5.05 % of python3 submissions (15.2 MB)
        # ivs = [(i, v) for i, v in enumerate(nums)]
        # ivs = sorted(ivs, key=lambda x: (x[1], x[0]))
        # i, j = 0, len(nums)-1
        # while i < j:
        #     tmp = ivs[i][1]+ivs[j][1]
        #     if tmp == target:
        #         return [ivs[i][0], ivs[j][0]]
        #     elif tmp < target:
        #         i += 1
        #     else:
        #         j -= 1
        # return []

        # # Hashtable: O(n), O(n)
        # # 29/29 cases passed (56 ms)
        # # Your runtime beats 97.15 % of python3 submissions
        # # Your memory usage beats 33.06 % of python3 submissions (14.3 MB)
        # v2i = {}
        # for i, v in enumerate(nums):
        #     if target-v in v2i:
        #         return [v2i[target-v], i]
        #     v2i[v] = i

        # return []

        # 2019-12-14 11:03:46
        # T~O(n), S~O(n)
        v2i = {}
        for i, v in enumerate(nums):
            if target-v in v2i:
                return [v2i[target-v], i]

            if v not in v2i:    # 可选条件判断
                v2i[v] = i
        # @lc code=end
