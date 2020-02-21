class Solution:

  def generateParenthesis(self, n: int) -> List[str]:
    result = []
    self.dfs(n, 0, 0, "", result)
    return result

  def dfs(self, n, left, right, node, result):
    if left == n and right == n:
      result.append(node)
    if left < n:
      self.dfs(n, left + 1, right, node + "(", result)
    if right < left:
      self.dfs(n, left, right + 1, node + ")", result)

