#
# @lc app=leetcode.cn id=1 lang=python3
#
# [1] 两数之和
#

# @lc code=start

# 解法一， 用暴力破解法，直接用两层循环遍历数组，找到和为指定target的整数，并返回下标
# 这个是 O(n*n)时间复杂度
# class Solution:
#     def twoSum(self, nums: List[int], target: int) -> List[int]:
#         for i in range(len(nums)):
#             for j in range(i + 1, len(nums)):
#                 if nums[i] + nums[j] == target:
#                     return [i,j]
#                     break

# 解法二，使用hash表，先用hash表存储每个整数以及它对应的下标，键为nums[i],值为i
# 然后再遍历nums数组，找到target-nums[i]键对应的values值，返回i 和 values
# 使用遍历函数 enumerate
class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        res = {}
        for i, item in enumerate(nums):
            res[item] = i
        for iid, item in enumerate(nums):
            con = target - item
            j = res.get(con)
            if j is not None and iid != j:
                return [iid, j]

        
# @lc code=end

