from typing import List


class Solution:
  # [right(i,j) - left(i,j)] * height(i,j)
  #
  # left(i,j) = max(left(i-1,j), cur_left)
  #
  # right(i,j) = min(right(i-1,j), cur_right)
  #
  # height(i,j) = height(i-1,j) + 1, if matrix[i][j] == '1'
  # height(i,j) = 0, if matrix[i][j] == '0'
  def maximalRectangle(self, matrix: List[List[str]]) -> int:
    if len(matrix) == 0: return 0
    rows = len(matrix)
    cols = len(matrix[0])
    left = [0] * cols
    right = [cols] * cols
    height = [0] * cols
    result = 0
    for row in range(rows):
      curLeft, curRight = 0, cols
      for col in range(cols):
        if matrix[row][col] == '1':
          height[col] += 1
        else:
          height[col] = 0
      for col in range(cols):
        if matrix[row][col] == '1':
          left[col] = max(left[col], curLeft)
        else:
          left[col] = 0
          curLeft = col + 1
      for col in range(cols - 1, -1, -1):
        if matrix[row][col] == '1':
          right[col] = min(right[col], curRight)
        else:
          right[col] = cols
          curRight = col
      for col in range(cols):
        curResult = (right[col] - left[col]) * height[col]
        result = max(result, curResult)
    return result


matrix = [
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
s = Solution()
result = s.maximalRectangle(matrix)
print(result)
