#
# @lc app=leetcode.cn id=78 lang=python3
#
# [78] 子集
#

# @lc code=start

# 回溯算法的题目，核心是能回到最开始状态，然后再重新开始下一轮
# 解法一，用库函数
# class Solution:
#     def subsets(self, nums: List[int]) -> List[List[int]]:
#         res = []
#         for i in range(len(nums) + 1):
#             for tmp in itertools.combinations(nums, i):
#                 res.append(tmp)
#         return res

# 解法二，迭代解法，求一个整数数组的子集，相当于整数数组的各个元素可自由组合，包括空集
# 相当于有一堆人要组队或不组队（特例，即空集），组队的规则是队内至少有一个人
# 那么让一个人先站出来，然后第二个人站出来可选择自己成一队或者加入已有队伍
# ，直至第k个人站出来选择自己成一队或者加入已有队伍，当所有人都站出来了，所有的组合可能性
# 就是题解了
class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        res = [[]]
        for i in nums:
            res = res + [[i] + num for num in res]
        return res




# @lc code=end

