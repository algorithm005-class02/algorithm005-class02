class Solution:
  def totalNQueens(self, n: int) -> int:
    self.count = 0
    def dfs(cols, pie, na, row):
      if row >= n:
        self.count += 1
        return
      bits = (~(cols|pie|na)) & ((1<<n) - 1)
      while bits:
        p = bits & -bits
        bits = bits & (bits - 1)
        dfs(cols|p, (pie|p)<<1, (na|p)>>1, row+1)
    dfs(0, 0, 0, 0)
    return self.count

s = Solution()
result = s.totalNQueens(8)
print(result)
