#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 解法一，递归方法，依次递归遍历根节点/左子树/右节点
# class Solution:
#     def preorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         def helper(root):
#             if not root:
#                 return
#             res.append(root.val)
#             helper(root.left)
#             helper(root.right)
#         helper(root)
#         return res

# 解法二，递归解法，原理同二叉树的中序遍历，选用栈stack，按根节点/右子树/左子树依次压入
class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return
        stack = [root]
        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return res

# @lc code=end

