#
# @lc app=leetcode.cn id=66 lang=python3
#
# [66] 加一
#
# https://leetcode-cn.com/problems/plus-one/description/
#
# algorithms
# Easy (41.53%)
# Likes:    373
# Dislikes: 0
# Total Accepted:    95.1K
# Total Submissions: 227K
# Testcase Example:  '[1,2,3]'
#
# 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
# 
# 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
# 
# 你可以假设除了整数 0 之外，这个整数不会以零开头。
# 
# 示例 1:
# 
# 输入: [1,2,3]
# 输出: [1,2,4]
# 解释: 输入数组表示数字 123。
# 
# 
# 示例 2:
# 
# 输入: [4,3,2,1]
# 输出: [4,3,2,2]
# 解释: 输入数组表示数字 4321。
# 
# class Solution:
#     def plusOne(self, digits: List[int]) -> List[int]:
#         length = len(digits)

#         if length == 0:
#             return [1]
        
#         end = length - 1
#         sum = 1      

#         while sum > 0 and end >= 0:
#             sum += digits[end]
#             if sum < 10:
#                 digits[end] = sum
#                 sum = 0
#             else:
#                 digits[end] = sum - 10
#                 end -= 1
#                 sum = 1

#         if sum > 0:
#             digits.insert(0, sum)
#         return digits

# @lc code=start
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        n = len(digits)
        i = n - 1
        sum = 1

        while sum > 0 and i >= 0:
            sum += digits[i]
            if sum <= 9:
                digits[i] = sum
                return digits
            else:
                digits[i] = sum - 10
                sum = 1
                i -= 1
        
        if sum > 0:
            digits.insert(0, sum)
        
        return digits

# @lc code=end

