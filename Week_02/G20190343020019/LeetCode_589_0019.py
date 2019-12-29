#
# @lc app=leetcode.cn id=589 lang=python3
#
# [589] N叉树的前序遍历
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
    def preorder(self, root: 'Node') -> List[int]:
        # 1. 递归法
        # def helper(node: 'Node', res: list):
        #     if node:
        #         res.append(node.val)
        #         for child in node.children:
        #             helper(child, res)
        # res = []
        # helper(root, res)
        # return res

        # 2. 标记法
        stack = root and [(root, False)]
        ans = []
        while stack:
            node, is_visited = stack.pop()
            if is_visited:
                ans.append(node.val)
            else:
                for child in node.children[::-1]:
                    stack.append((child, False))
                stack.append((node, True))
        return ans

        
# @lc code=end

