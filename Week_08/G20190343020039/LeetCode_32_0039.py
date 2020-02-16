class Solution:
  # dp[i] 为以下标 i 结尾的最长有效子字符串的长度。

  # s[i] == ')' && s[i-1] == '('
  #   dp[i] = dp[i-2] + 2

  # s[i] == ')' && s[i-1] == ')' && s[i - dp[i-1] - 1] == '('
  #   dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2
  def longestValidParentheses(self, s: str) -> int:
    result = 0
    dp = [0] * len(s)
    for i in range(1, len(s)):
      if s[i] == '(': continue
      if s[i-1] == '(':
        if i-2 > 0:
          dp[i] = dp[i-2] + 2
        else:
          dp[i] = 2
      elif i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1] == '(':
        if i-dp[i-1]-2 >= 0:
          dp[i] = dp[i-1] + dp[i-dp[i-1]-2] + 2
        else:
          dp[i] = dp[i-1] + 2
      result = max(result, dp[i])
    return result

