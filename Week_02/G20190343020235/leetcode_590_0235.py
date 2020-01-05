"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        def p_o(root):
            if not root:
                return
            for c in root.children:
                p_o(c)
            res.append(root.val)
        p_o(root)
        return res