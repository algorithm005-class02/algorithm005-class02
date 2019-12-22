#
# @lc app=leetcode.cn id=236 lang=python3
#
# [236] 二叉树的最近公共祖先
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# 解法一
# class Solution:
#     def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
#         if root in (None, p, q): return root
#         left, right = (self.lowestCommonAncestor(kid, p, q) 
#                         for kid in (root.left, root.right))
#         return root if left and right else left or right 

# 解法二
class Solution:
    def __init__(self):
        self.ans = None
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def recurse_tree(current_node):
            # 判断递归结束的条件
            if not current_node:
                return False

            # 处理过程

            # 往下一层走 down
            left = recurse_tree(current_node.left)
            right = recurse_tree(current_node.right)

            # 当层处理过程
            mid = current_node == p or current_node == q
            if mid + left + right >= 2:
                self.ans = current_node
            return mid or left or right

            # 清理当层变量
        recurse_tree(root)
        return self.ans
        

# @lc code=end

