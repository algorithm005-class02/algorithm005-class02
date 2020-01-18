#
# @lc app=leetcode.cn id=50 lang=python3
#
# [50] Pow(x, n)
#

# @lc code=start


class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0:
            return 1.0
        #  pa
        if n < 0:
            n = -n
            x = 1/x
        r = self.myPow(x, int(n/2))
        return r * r if n % 2 == 0 else r*r*x


# @lc code=end
Solution().myPow(2.0, 10)
