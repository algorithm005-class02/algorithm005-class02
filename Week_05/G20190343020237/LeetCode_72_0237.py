#
# @lc app=leetcode.cn id=72 lang=python3
#
# [72] 编辑距离
#
# https://leetcode-cn.com/problems/edit-distance/description/
#
# algorithms
# Hard (55.69%)
# Likes:    461
# Dislikes: 0
# Total Accepted:    23.9K
# Total Submissions: 42.9K
# Testcase Example:  '"horse"\n"ros"'
#
# 给定两个单词 word1 和 word2，计算出将 word1 转换成 word2 所使用的最少操作数 。
#
# 你可以对一个单词进行如下三种操作：
#
#
# 插入一个字符
# 删除一个字符
# 替换一个字符
#
#
# 示例 1:
#
# 输入: word1 = "horse", word2 = "ros"
# 输出: 3
# 解释:
# horse -> rorse (将 'h' 替换为 'r')
# rorse -> rose (删除 'r')
# rose -> ros (删除 'e')
#
#
# 示例 2:
#
# 输入: word1 = "intention", word2 = "execution"
# 输出: 5
# 解释:
# intention -> inention (删除 't')
# inention -> enention (将 'i' 替换为 'e')
# enention -> exention (将 'n' 替换为 'x')
# exention -> exection (将 'n' 替换为 'c')
# exection -> execution (插入 'u')
#
#
#

# @lc code=start


class Solution:
    def minDistance(self, word1: str, word2: str) -> int:

        len1, len2 = len(word1) + 1, len(word2) + 1
        dp = [[None] * len2 for _ in range(len1)]
        for i in range(len1): dp[i][0] = i
        for j in range(len2): dp[0][j] = j
        dp[0][0] = 0
        for i in range(1, len1):
            for j in range(1, len2):
                dp[i][j] = min(dp[i - 1][j] + 1,
                               dp[i][j - 1] + 1,
                               dp[i - 1][j - 1] if word1[i - 1] == word2[j - 1] else (dp[i - 1][j - 1] + 1)
                               )
        return dp[-1][-1]

# @lc code=end
