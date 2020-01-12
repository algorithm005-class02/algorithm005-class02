int longestValidParentheses(char * s){
  int i, j, len, max;
  int *dp;

  len = strlen(s);
  if (len == 0)
    return 0;

  dp = (char *)malloc(len * sizeof(int));
  memset(dp, 0, len * sizeof(int));

  max = 0;

  for (i = len - 2; i >= 0; i--)
  {
    if (s[i] == '(') {
      j = i + 1 + dp[i + 1];
      if (j < len && s[j] == ')') {
        dp[i] = dp[i + 1] + 2;
        if (j + 1 < len)
          dp[i] += dp[j + 1];
      }
    }
    if (max < dp[i])
      max =dp[i];
  }
  return max;
}
