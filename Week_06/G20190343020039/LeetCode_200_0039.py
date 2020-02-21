class Solution:

  def numIslands(self, grid: List[List[str]]) -> int:
    if not grid: return 0
    rows = len(grid)
    cols = len(grid[0])
    p = {}
    for row in range(rows):
      for col in range(cols):
        if grid[row][col] == "1":
          p[row * cols + col] = row * cols + col

    directions = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    for row in range(rows):
      for col in range(cols):
        if grid[row][col] == "1":
          for _, dirs in enumerate(directions):
            newRow = row + dirs[0]
            newCol = col + dirs[1]
            if self.isValid(grid, newRow, newCol):
              self.union(p, row * cols + col, newRow * cols + newCol)

    return len(set([self.parent(p, key) for key in p]))

  def isValid(self, grid, row, col):
    if row < 0 or row >= len(grid):
      return False
    if col < 0 or col >= len(grid[0]):
      return False
    if grid[row][col] == "0":
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
