#
# @lc app=leetcode.cn id=15 lang=python3
#
# [15] 三数之和
#

# @lc code=start

# 第一种解法，三层循环暴力破解法
# 这里颇费了些时间，一者是对数组/元组/集合之间的转换不熟悉
# 不清楚列表可以排序，集合可以去重等基础操作，导致一直出现重复答案这个事情
# 二者，则是对题目理解不透彻，是任意无放回地取3个元素，刚开始理解成有放回
# 导致答案中出现[0, 0, 0]这种重复元素的情况
# 另外在三层循环的时候，无放回，下一层循环应该是从 i + 1 开始！
# class Solution:
#     def threeSum(self, nums: List[int]) -> List[List[int]]:
#         output = []
#         tmp = []
#         for i in range(len(nums)-2):
#             for j in range(i + 1,len(nums)-1):
#                 for k in range(j + 1,len(nums)):
#                     if nums[i] + nums[j] + nums[k] == 0:
#                         output.append(tuple(sorted([nums[i], nums[j], nums[k]])))
       
#         return list(set(output))

# 双指针解法
class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        output = []
        nums.sort()
        for i in range(len(nums)-2):
            if i > 0 and nums[i] == nums[i-1]:
                continue
            l, r = i+1, len(nums)-1
            while l < r:
                s = nums[i] + nums[l] + nums[r]
                if s < 0:
                    l += 1
                elif s > 0:
                    r -= 1
                else:
                    output.append((nums[i], nums[l], nums[r]))
                    if l < r and nums[l] == nums[l+1]:
                        l += 1
                    if l < r and nums[r] == nums[r-1]:
                        r -=1
                    l += 1 ; r -= 1
                    
        return list(set(output))


# @lc code=end

