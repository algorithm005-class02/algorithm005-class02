class Solution:
  # dp[i][j] 表示 t 的前 i 个字符串可以有 s 的前 j 个字符串组成的最多个数
  # s[j] == t[i], dp[i][j] = dp[i-1][j-1] + dp[i][j-1]
  # s[j] != t[i], dp[i][j] = dp[i][j-1]
  def numDistinct(self, s: str, t: str) -> int:
    rows = len(t) + 1
    cols = len(s) + 1
    dp = [[0 for _ in range(cols)] for _ in range(rows)]
    for col in range(cols):
      dp[0][col] = 1
    for row in range(1, rows):
      for col in range(1, cols):
        if s[col-1] == t[row-1]:
          dp[row][col] = dp[row-1][col-1] + dp[row][col-1]
        else:
          dp[row][col] = dp[row][col-1]
    return dp[-1][-1]

