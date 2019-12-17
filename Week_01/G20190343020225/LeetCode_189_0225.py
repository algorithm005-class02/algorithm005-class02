#
# @lc app=leetcode.cn id=189 lang=python3
#
# [189] 旋转数组
#

# @lc code=start
class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        
        k = k % len(nums)
        if k == 0 or len(nums) ==1:
            return nums
        # if len(nums) == 2:
        #     nums.reverse()

        for i in range(len(nums),len(nums)-k,-1):
            j = nums[i]
            nums.remove(j)
            nums.insert(0,j)
        return nums

# @lc code=end

