'''
@Author: your name
@Date: 2019-12-26 09:47:23
@LastEditTime : 2019-12-26 10:33:14
@LastEditors  : Please set LastEditors
@Description: In User Settings Edit
@FilePath: \leetcode\102.二叉树的层次遍历.py
'''
#
# @lc app=leetcode.cn id=102 lang=python3
#
# [102] 二叉树的层次遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

# class Solution:
    # def levelOrder(self, root: TreeNode) -> List[List[int]]:
    #     levels = []
    #     if not root:
    #         return levels
    #     def helper(node, level):
    #         if len(levels) == level:
    #             levels.append([])
    #         levels[level].append(node.val)
    #         if node.left:
    #             helper(node.left,level+1)
    #         if node.right:
    #             helper(node.right,level+1)
    #     helper(root,0)
    #     return levels
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result,queue = [],[root]
        if not root:
            return []
        while queue:
            node = queue.pop(0)
            result.append[[node.val]]
            if node.left:
                queue.append(node.left)
            if node.right:
                queue.append(node.right)
        return result
            

# @lc code=end

