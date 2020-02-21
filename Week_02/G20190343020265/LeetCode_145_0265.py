#
# @lc app=leetcode.cn id=145 lang=python3
#
# [145] 二叉树的后序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 解法一，递归解法， 顺序是左、右、根节点
# class Solution:
#     def postorderTraversal(self, root: TreeNode) -> List[int]:
#         res = []
#         def helper(root):
#             if not root:
#                 return
#             helper(root.left)
#             helper(root.right)
#             res.append(root.val)
#         helper(root)
#         return res

# 解法二，栈的迭代解法， 顺序是左、右、根节点
class Solution:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        if not root:
            return
        stack = [root]
        while stack:
            node = stack.pop()
            if node.left:
                stack.append(node.left)
            if node.right:
                stack.append(node.right)
            res.append(node.val)
        return res[::-1]

# @lc code=end

