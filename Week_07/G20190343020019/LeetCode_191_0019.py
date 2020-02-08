#
# @lc app=leetcode.cn id=191 lang=python3
#
# [191] 位1的个数
#

# @lc code=start
class Solution:
    def hammingWeight(self, n: int) -> int:
        cnt = 0
        while n:
            cnt += 1
            n = n & (n - 1)
        return cnt
# @lc code=end

