# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        traverse_path = []
        def inorder(root):
            if root:
                inorder(root.left)
                traverse_path.append(root.val)
                inorder(root.right)
        inorder(root)
        return traverse_path