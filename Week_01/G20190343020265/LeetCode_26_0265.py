#
# @lc app=leetcode.cn id=26 lang=python3
#
# [26] 删除排序数组中的重复项
#

# @lc code=start
# 解法一，不额外采用指针，直接是在单指针的方式下进行原地操作
# 这种解法空间复杂度特别低， 但是时间复杂度不是最好的
# class Solution:
#     def removeDuplicates(self, nums: List[int]) -> int:
#         curr_num = 0
#         while curr_num < len(nums) - 1:
#             if nums[curr_num] == nums[curr_num + 1]:
#                 del nums[curr_num]
#                 curr_num -= 1
#             curr_num += 1
#         return len(nums)

# 解法二，采用双指针的方法， 时间复杂度提升明显，应该是因为没有del的操作
# 双指针法只是做了数据赋值的一个操作
class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        curr_num = 0
        for j in range(1, len(nums)):
            if nums[curr_num] != nums[j]:
                curr_num += 1
                nums[curr_num] = nums[j]

        return curr_num + 1

# @lc code=end

