"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        def pre_o(root):
            if not root:
                return
            res.append(root.val)
            for c in root.children:
                pre_o(c)
        pre_o(root)
        return res