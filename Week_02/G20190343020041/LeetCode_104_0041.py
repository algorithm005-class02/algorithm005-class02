
#
# @lc app=leetcode.cn id=104 lang=python3
#
# [104] 二叉树的最大深度
#

# @lc code=start
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def maxDepthRecursion(self, root: TreeNode) -> int:
        if root:
            return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
        return 0

    def maxDepth(self, root: TreeNode) -> int:
        stack = [(root, 1)]
        max_depth = 0
        while stack:
            curr = stack.pop()
            if curr and curr[0]:
                max_depth = max(max_depth, curr[1])
                stack.append((curr[0].left, curr[1] + 1))
                stack.append((curr[0].right, curr[1] + 1))
        return max_depth
# @lc code=end
