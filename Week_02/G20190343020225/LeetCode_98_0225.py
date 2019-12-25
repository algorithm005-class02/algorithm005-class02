# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 中序遍历
# class Solution:
#     def isValidBST(self, root: TreeNode) -> bool:
#         output = []
#         self.inorder(root,output)

#         for i in range(1, len(output)):
#             if output[i-1] >= output[i]:
#                 return False
#         return True

#     def inorder(self,root,output):
#         if root is None:
#             return
#         self.inorder(root.left,output)
#         output.append(root.val)
#         self.inorder(root.right,output)

# 递归
class Solution:
    def isValidBST(self, root: TreeNode,lower=float('-inf'),upper=float('inf')) -> bool:
        if not root:
            return True
        if not lower < root.val < upper:
            return False
        return self.isValidBST(root.left,lower,root.val) and self.isValidBST(root.right,root.val,upper)


# class Solution(object):
#     def isValidBST(self, root):
#         """
#         :type root: TreeNode
#         :rtype: bool
#         """
#         def valid(node, lower, upper):
#             if not node:
#                 return True
#             if lower is not None and node.val <= lower:
#                 return False
#             if upper is not None and node.val >= upper:
#                 return False
#             return valid(node.left, lower, node.val) and valid(node.right, node.val, upper)
#         return valid(root, None, None)