class Solution:

  def isMatch(self, s: str, p: str) -> bool:
    m = {}
    def dfs(i, j):
      if (i, j) in m:
        return m[(i, j)]
      if len(p) == j:
        return len(s) == i
      if p[j] == '*':
        result = dfs(i, j + 1) or i < len(s) and dfs(i + 1, j)
      else:
        firstMatch = (i < len(s)) and (p[j] == s[i] or p[j] == '?')
        result = firstMatch and dfs(i + 1, j + 1)
      m[(i, j)] = result
      return result
    return dfs(0, 0)


s = "acdcb"
p = "a*c?b"
solu = Solution()
result = solu.isMatch(s, p)
print(result)
