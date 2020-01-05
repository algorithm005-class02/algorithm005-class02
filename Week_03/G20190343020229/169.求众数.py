#
# @lc app=leetcode.cn id=169 lang=python3
#
# [169] 求众数
#
# https://leetcode-cn.com/problems/majority-element/description/
#
# algorithms
# Easy (60.57%)
# Likes:    395
# Dislikes: 0
# Total Accepted:    94.8K
# Total Submissions: 155.6K
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

class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        result = None
        count = 0

        for i in nums:
            if count == 0:
                result = i
            count += 1 if i == result else -1
        
        return result

# @lc code=end

