# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        left_len = self.maxDepth(root.left)
        right_len = self.maxDepth(root.right)
        if left_len > right_len:
            return left_len + 1
        else:
            return right_len + 1