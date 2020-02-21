class Solution:

  def solve(self, board: List[List[str]]) -> None:
    """
    Do not return anything, modify board in-place instead.
    """
    if not board: return

    rows = len(board)
    cols = len(board[0])
    dummy = rows * cols
    p = {dummy: dummy}

    for row in range(rows):
      for col in range(cols):
        if board[row][col] == "O":
          p[row * cols + col] = row * cols + col

    directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    for row in range(rows):
      for col in range(cols):
        if board[row][col] == "O":
          if self.isBoundary(board, row, col):
            self.union(p, row * cols + col, dummy)
          else:
            for _, dirs in enumerate(directions):
              newRow, newCol = row + dirs[0], col + dirs[1]
              if self.isValid(board, newRow, newCol):
                self.union(p, row * cols + col, newRow * cols + newCol)

    for row in range(rows):
      for col in range(cols):
        if board[row][col] == "O":
          p1 = self.parent(p, row * cols + col)
          p2 = self.parent(p, dummy)
          if p1 == p2:
            board[row][col] = "O"
          else:
            board[row][col] = "X"

  def isBoundary(self, board, row, col):
    if row == 0 or row == len(board) - 1:
      return True
    if col == 0 or col == len(board[0]) - 1:
      return True
    return False

  def isValid(self, grid, row, col):
    if row < 0 or row >= len(grid):
      return False
    if col < 0 or col >= len(grid[0]):
      return False
    if grid[row][col] == "X":
      return False
    return True

  def union(self, p, i, j):
    p1 = self.parent(p, i)
    p2 = self.parent(p, j)
    p[p1] = p2

  def parent(self, p, i):
    root = i
    while p[root] != root:
      root = p[root]
    while p[i] != i:
      x = i
      i = p[i]
      p[x] = root
    return root
