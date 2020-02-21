#
# @lc app=leetcode.cn id=33 lang=python3
#
# [33] 搜索旋转排序数组
#
# https://leetcode-cn.com/problems/search-in-rotated-sorted-array/description/
#
# algorithms
# Medium (36.09%)
# Likes:    423
# Dislikes: 0
# Total Accepted:    56.7K
# Total Submissions: 156.6K
# Testcase Example:  '[4,5,6,7,0,1,2]\n0'
#
# 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
# 
# ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
# 
# 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
# 
# 你可以假设数组中不存在重复的元素。
# 
# 你的算法时间复杂度必须是 O(log n) 级别。
# 
# 示例 1:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 0
# 输出: 4
# 
# 
# 示例 2:
# 
# 输入: nums = [4,5,6,7,0,1,2], target = 3
# 输出: -1
# 
#
# @lc code=start
class Solution:
    def search(self, nums: List[int], target: int) -> int:
        n = len(nums)
        if n == 0:
            return -1
        if n == 1:
            return 0 if target == nums[0] else -1
        l = 0
        r = n - 1
        rotate = 0

        while l < r:
            m = l + (r - l) // 2
            mid = nums[m]
            # print(l, r, m)
            if m > 0 and mid < nums[m - 1]:
                rotate = m
                break
            elif mid >= nums[r]:
                l = m + 1
            elif mid <= nums[l]:
                r = m - 1
            else:
                r -= 1
        if l == r and l > 0 and nums[l] < nums[l - 1]:
            rotate = l
        # print(rotate)
        last = nums[n - 1]

        if last == target:
            return n - 1
        elif target < last:
            l = rotate
            r = n - 1
        else:
            l = 0
            r = rotate - 1
        # print(l, r, rotate)
        
        while l < r:
            m = l + (r - l) // 2
            mid = nums[m]
            if mid == target:
                return m
            elif mid < target:
                l = m + 1
            else:
                r = m - 1
        if nums[l] == target:
            return l
        return -1

# @lc code=end
