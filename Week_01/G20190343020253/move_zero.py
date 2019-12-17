#
# @lc app=leetcode.cn id=283 lang=python3
#
# [283] 移动零
#

# @lc code=start
class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        # v1
        # 暴力方法，直接修改数组元素
        # 时间复杂度：O(n^2). Array 的删除操作最坏情况下是 O(n)
        # for i, n in enumerate(nums):
        #     if n == 0:
        #         nums.remove(n)
        #         nums.append(n)


        # v2 
        # 双指针遍历，以空间换时间。一个指针记录非零元素的位置，另一个指针遍历数组
        # 时间复杂度：O(n)
        # j = 0
        # for i, n in enumerate(nums):
        #     if n != 0:
        #         nums[j] = n
        #         if i != j:
        #             nums[i] = 0
        #         j += 1

        # v3
        # 遇到非零元素，直接与数组下一个元素置换
        # 时间复杂度：O(n)
        # 逻辑上不如V2 那么好理解，但是执行效率好一些
        j = 0
        for i in range(len(nums)):
            if nums[i] != 0:
                nums[i], nums[j] = nums[j], nums[i]
                j += 1
        
# @lc code=end

