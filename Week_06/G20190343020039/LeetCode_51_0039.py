class Solution:

  def solveNQueens(self, n: int) -> List[List[str]]:
    if n < 1: return []
    self.result = []
    self.cols = set()
    self.pie = set()
    self.na = set()
    self.dfs(n, 0, [])
    return [["." * i + "Q" + "." * (n - i - 1) for i in sol] for sol in self.result]

  def dfs(self, n, row, curState):
    if row >= n:
      self.result.append(curState)
      return

    for col in range(n):
      if col in self.cols or row + col in self.pie or row - col in self.na:
        continue

      self.cols.add(col)
      self.pie.add(row + col)
      self.na.add(row - col)

      self.dfs(n, row + 1, curState + [col])

      self.cols.remove(col)
      self.pie.remove(row + col)
      self.na.remove(row - col)
