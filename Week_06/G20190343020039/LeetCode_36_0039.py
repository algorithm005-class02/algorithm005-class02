class Solution:
  def isValidSudoku(self, board: List[List[str]]) -> bool:
    rows = len(board)
    cols = len(board[0])
    for row in range(rows):
      for col in range(cols):
        if board[row][col] == ".":
          continue
        c = board[row][col]
        board[row][col] = "."
        if not self.isValid(board, row, col, c):
          return False
        board[row][col] = c
    return True

  def isValid(self, board, row, col, c):
    for i in range(9):
      if board[i][col] == c:
        return False
      if board[row][i] == c:
        return False
      if board[row // 3 * 3 + i // 3][col // 3 * 3 + i % 3] == c:
        return False
    return True
