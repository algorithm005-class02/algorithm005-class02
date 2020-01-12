#
# @lc app=leetcode.cn id=72 lang=python3
#
# [72] 编辑距离
# 解题思路
# 动态规划的思路，1.拆解子问题；2.定义状态值；3.编辑递推公式；
# 1.拆解子问题：f(i,j) = f(i-1,j-1) if last_str==last_str else min(f(i-1,j),f(i,j-1),f(i-1,j-1))+1
# 2.定义状态值：dp[i][j]  动态规划过程值数组
# 3.递推公式：dp[i][j]=dp[i-1][j-1] if last_str=last_str else min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])+1

# @lc code=start
class Solution:
    def minDistance(self, word1: str, word2: str) -> int:
        len_1 = len(word1) + 1
        len_2 = len(word2) + 1
        dp = [[0]*len_1 for _ in range(len_2)]
        for i in range(1, len_2):
            dp[i][0] = dp[i-1][0] + 1
        for j in range(1, len_1):
            dp[0][j] = dp[0][j-1] + 1
        for i in range(1, len_2):
            for j in range(1, len_1):
                if word1[j-1] == word2[i-1]:
                    dp[i][j] = dp[i-1][j-1]
                else:
                    dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
        return dp[-1][-1] 

        
# @lc code=end

