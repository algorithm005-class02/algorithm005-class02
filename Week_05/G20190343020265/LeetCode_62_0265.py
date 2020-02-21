#
# @lc app=leetcode.cn id=62 lang=python3
#
# [62] 不同路径
#

# 对于动态规划的初始
# 动态规划其实就是动态递推，和分治/递归没有本质上的区别，不过动态递推是自底向上，
# 一步步递推到最终所求值；而分治/递归是自顶向下触底后一步步回归到初始出发的所求值；
# 分治/递归会增加记忆搜索来降低时间复杂度，(分治/递归+记忆化搜索)=>直接采用for循环递推
# 一维的典型例题就是Fibonacci数列，递推公式为:f(n)=f(n-1)+f(n-2)
# 二维的典型例题是不同路径，递推公式为：dp(i,j)=dp(i-1,j)+dp(i,j-1)
# @lc code=start
# 递推解法一，直接套公式
# class Solution:
#     def uniquePaths(self, m: int, n: int) -> int:
#         dp = [[1]*n] + [[1] + [0]*(n-1) for _ in range(m-1)]
#         for i in range(1, m):
#             for j in range(1, n):
#                 dp[i][j] = dp[i-1][j] + dp[i][j-1]
#         return dp[-1][-1]

# 递推解法二，性能优化，从O(m*n)空间复杂度降至O(n)，时间复杂度是没变的
class Solution:
    def uniquePaths(self, m: int, n: int) -> int:
        column = [1]*n             # 给出初始行的值：全为1
        for i in range(1, m):      # 逐行递推
            for j in range(1, n):  # 逐列更新值,递推公式就相当于自身加上右边值（从下往上）
                column[j] += column[j-1]
        return column[-1]

# @lc code=end

