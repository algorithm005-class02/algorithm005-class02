#
# @lc app=leetcode.cn id=590 lang=python3
#
# [590] N叉树的后序遍历
#

# @lc code=start
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res, stack = [], [(root, False)]
        while stack:
            node, is_visited = stack.pop()
            if not node: continue
            if is_visited:
                res.append(node.val)
            else:
                stack.append((node, True))
                size = len(node.children)
                for i in range(size):
                    stack.append((node.children[size - i - 1], False))
        return res

        
# @lc code=end

