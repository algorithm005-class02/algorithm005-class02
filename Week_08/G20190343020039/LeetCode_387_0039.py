class Solution:
  def firstUniqChar(self, s: str) -> int:
    m = {}
    for c in s:
      if c in m:
        m[c] += 1
      else:
        m[c] = 1
    for i in range(len(s)):
      c = s[i]
      if m[c] == 1:
        return i
    return -1

s = "leetcode"
solu = Solution()
result = solu.firstUniqChar(s)
print(result)

