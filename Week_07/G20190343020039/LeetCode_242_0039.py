class Solution:
  def isAnagram(self, s: str, t: str) -> bool:
    if len(s) != len(t): return False
    m = [0] * 26
    for i in range(len(s)):
      m[ord(s[i]) - 97] += 1
      m[ord(t[i]) - 97] -= 1
    return len(list(filter(lambda e: e > 0, m))) == 0

