class Solution:
  # dp[i][j]
  # i 表示字符串的起点
  # j 表示字符串的终点
  #
  # dp[i][j] = true 表示 s[i, j] 是回文串
  # dp[i][j] = false 表示 s[i, j] 不是回文串
  #
  # dp[i][j] = (dp[i+1][j-1] && s[i] == s[j])
  # 因为 s[i+1, j-1] 是回文串，且 s[i] == s[j]
  # 所以向左右两边扩展一个字母，则
  # dp[i][j] 也是回文串
  def longestPalindrome(self, s: str) -> str:
    n, result = len(s), ""
    dp = [[False for _ in range(n)] for _ in range(n)]
    for i in range(n - 1, -1, -1):
      for j in range(i, n):
        dp[i][j] = s[i] == s[j] and (j - i < 2 or dp[i + 1][j - 1])
        if dp[i][j] and j - i + 1 > len(result):
          result = s[i:j + 1]
    return result
