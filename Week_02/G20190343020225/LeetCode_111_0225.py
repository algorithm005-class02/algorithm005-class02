# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        if root.left == None and root.right == None:
            return 1
        left_len = self.minDepth(root.left)
        right_len = self.minDepth(root.right)
        if root.left == None or root.right == None:
            return left_len + right_len + 1
        return min(left_len,right_len) + 1