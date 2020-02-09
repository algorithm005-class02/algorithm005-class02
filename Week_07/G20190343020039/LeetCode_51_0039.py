class Solution:
  def solveNQueens(self, n: int) -> List[List[str]]:
    result = []
    def dfs(cols, pie, na, row, curState):
      if row == n:
        result.append(curState)
        return
      for col in range(n):
        if (col not in cols) and (row + col not in pie) and (row - col not in na):
          dfs(cols|{col}, pie|{row+col}, na|{row-col}, row+1, curState+[col])
    dfs(set(), set(), set(), 0, [])
    return [["."*i + "Q" + "."*(n-i-1) for i in sol] for sol in result]
