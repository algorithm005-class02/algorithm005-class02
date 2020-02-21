"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def postorder0(self, root: 'Node') -> List[int]:
        def dfs(root):
            if not root:
                return
            for c in root.children:
                dfs(c)
            res.append(root.val)
        res = []
        dfs(root)
        return res

    def postorder1(self, root: 'Node') -> List[int]:
        if not root:
            return
        res,stack = [],[root]
        while stack:
            node = stack.pop()
            res.append(node.val)
            stack += [c for c in node.children if c]
        return res[::-1]