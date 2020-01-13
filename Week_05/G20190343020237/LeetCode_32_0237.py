#
# @lc app=leetcode.cn id=32 lang=python3
#
# [32] 最长有效括号
#
# https://leetcode-cn.com/problems/longest-valid-parentheses/description/
#
# algorithms
# Hard (28.95%)
# Likes:    457
# Dislikes: 0
# Total Accepted:    33.9K
# Total Submissions: 116.4K
# Testcase Example:  '"(()"'
#
# 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
#
# 示例 1:
#
# 输入: "(()"
# 输出: 2
# 解释: 最长有效括号子串为 "()"
#
#
# 示例 2:
#
# 输入: ")()())"
# 输出: 4
# 解释: 最长有效括号子串为 "()()"
#
#
#

# @lc code=start


class Solution:
    def longestValidParentheses(self, s: str) -> int:

        # 1. 枚举 O(2^n)
        # 2. DFS: 剪枝
        # 3. DP?
        # DP
        if len(s) <= 1:
            return 0

        n = len(s)
        dp = [None] * n
        dp[0] = ''
        dp[1] = '()' if s[0] == '(' and s[1] == ')' else ''
        for i in range(2, n):
            if s[i] == '(':
                dp[i] = ''
            elif s[i] == ')' and s[i - 1] == '(':
                dp[i] = dp[i - 2] + '()'
            elif s[i] == ')' and s[i - 1] == ')':
                i_start = i - 1 - len(dp[i - 1])
                if i_start >= 0 and s[i_start] == '(':
                    if i_start >= 1:
                        dp[i] = dp[i_start - 1] + '(' + dp[i - 1] + ')'
                    else:
                        dp[i] = '(' + dp[i - 1] + ')'
                else:
                    dp[i] = ''
        ans = 0
        for e in dp:
            if len(e) > ans:
                ans = len(e)
        return ans


# @lc code=end
