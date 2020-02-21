# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

from collections import deque
class Solution:
  def levelOrder(self, root: TreeNode) -> List[List[int]]:
    if root == None:
      return []
    result = []
    queue = deque([root,])
    while len(queue) > 0:
      levelSize = len(queue)
      currentLevel = []
      for i in range(levelSize):
        node = queue.popleft()
        currentLevel.append(node.val)
        if node.left:
          queue.append(node.left)
        if node.right:
          queue.append(node.right)
      result.append(currentLevel)
    return result

