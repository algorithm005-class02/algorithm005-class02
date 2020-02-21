#
# @lc app=leetcode.cn id=231 lang=python3
#
# [231] 2的幂
#
# https://leetcode-cn.com/problems/power-of-two/description/
#
# algorithms
# Easy (47.28%)
# Likes:    155
# Dislikes: 0
# Total Accepted:    43.5K
# Total Submissions: 91.8K
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

# @lc code=start


class Solution:
    def isPowerOfTwo(self, n: int) -> bool:

        # O(1)
        # ---------------------------------------------------
        # Accepted
        # 1108/1108 cases passed (40 ms)
        # Your runtime beats 48.03 % of python3 submissions
        # Your memory usage beats 51.67 % of python3 submissions (13 MB)
        # return (n & n - 1) == 0 if n != 0 else False

        return (n != 0) and (n & n - 1) == 0

# @lc code=end
