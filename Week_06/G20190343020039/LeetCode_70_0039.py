class Solution:

  def climbStairs(self, n: int) -> int:
    return self.recursion(n, {})

  def recursion(self, n, m):
    if n < 3:
      return n
    if n in m:
      return m[n]
    m[n] = self.recursion(n - 1, m) + self.recursion(n - 2, m)
    return m[n]
