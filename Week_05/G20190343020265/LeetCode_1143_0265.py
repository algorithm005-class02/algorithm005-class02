#
# @lc app=leetcode.cn id=1143 lang=python3
#
# [1143] 最长公共子序列
# 首先，将两个string分别做行和列，根据每个字符构成一个二维表
# 动态规划三步走：第一步是尝试分解子问题，如两个字符串的最长公共子序列，可以分解为
# 两个字符串各自的子集的最长公共子序列问题；第二步是存储的数组；第三步是递推的公式
# 这里的递推逻辑是：1.如果最后一位字符相同，则f(i,j)=f(i-1,j-1)+1；
# 2.否则f(i,j)=max(f(i-1,j),f(i,j-1))

# @lc code=start
class Solution:
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        if not text1 or not text2:
            return 0
        dp = [[0]*(len(text2) + 1) for _ in range(len(text1) + 1)]
        for i in range(1, len(text1) + 1):
            for j in range(1, len(text2) + 1):
                tmp1, tmp2 = text1[:i], text2[:j]
                if tmp1[-1] == tmp2[-1]:
                    dp[i][j] = dp[i-1][j-1] + 1
                else:
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1])
        return dp[-1][-1]

        
# @lc code=end

