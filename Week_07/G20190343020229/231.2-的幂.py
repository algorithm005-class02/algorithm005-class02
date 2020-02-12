#
# @lc app=leetcode.cn id=231 lang=python3
#
# [231] 2的幂
#
# https://leetcode-cn.com/problems/power-of-two/description/
#
# algorithms
# Easy (46.93%)
# Likes:    155
# Dislikes: 0
# Total Accepted:    43.4K
# Total Submissions: 91.5K
# Testcase Example:  '1'
#
# 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
# 
# 示例 1:
# 
# 输入: 1
# 输出: true
# 解释: 2^0 = 1
# 
# 示例 2:
# 
# 输入: 16
# 输出: true
# 解释: 2^4 = 16
# 
# 示例 3:
# 
# 输入: 218
# 输出: false
# 
#

# 2020-02-03 23:01 - 23:02 40ms 48.68 
# 尝试用位的运算，判断是否只有一个1
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        return False if n == 0 else n & (n - 1) == 0

# 展开来写，时间变快了 32ms  84.93%
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False

        return n & (n - 1) == 0

# 换另一种方法，取最右边的1，然后是否还和自己相同（如果只有一个1的话），28ms 94.65%
# @lc code=start
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        if n == 0:
            return False

        return n & (-n) == n

# @lc code=end

