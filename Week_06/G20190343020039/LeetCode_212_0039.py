class Solution:

  def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
    self.root = {}
    self.endOfWord = "#"
    for word in words:
      self.insert(word)

    rows = len(board)
    cols = len(board[0])
    visited = [[False for j in range(cols)] for i in range(rows)]
    result = set()
    for row in range(rows):
      for col in range(cols):
        self.dfs(self.root, board, row, col, "", result, visited)
    return list(result)

  def dfs(self, node, board, row, col, curStr, result, visited):
    if self.endOfWord in node:
      result.add(curStr)
    if not self.canWalk(board, row, col, visited):
      return
    char = board[row][col]
    if char not in node:
      return
    visited[row][col] = True
    for x, y in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
      self.dfs(node[char], board, row+x, col+y, curStr+char, result, visited)
    visited[row][col] = False

  def canWalk(self, board, row, col, visited):
    if row < 0 or row >= len(board):
      return False
    if col < 0 or col >= len(board[0]):
      return False
    if visited[row][col]:
      return False
    return True

  def insert(self, word):
    node = self.root
    for char in word:
      node = node.setdefault(char, {})
    node[self.endOfWord] = self.endOfWord

