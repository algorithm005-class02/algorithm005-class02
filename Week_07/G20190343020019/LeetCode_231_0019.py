#
# @lc app=leetcode.cn id=231 lang=python3
#
# [231] 2的幂
#

# @lc code=start
class Solution:
    def isPowerOfTwo(self, n: int) -> bool:
        # 位运算   85% 52%
        return n != 0 and n & (n - 1) == 0
        
# @lc code=end

