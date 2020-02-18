class Solution:
  # dp[i] = dp[i-1] + dp[i-2]
  def numDecodings(self, s: str) -> int:
    if len(s) == 0: return 0
    dp = [0] * len(s)
    if s[0] != '0':
      dp[0] = 1
    for i in range(1, len(s)):
      first = int(s[i])
      second = int(s[i-1:i+1])
      if first >= 1 and first <= 9:
        dp[i] += dp[i-1]
      if second >= 10 and second <= 26:
        if i >= 2:
          dp[i] += dp[i-2]
        else:
          dp[i] += 1
    return dp[-1]

