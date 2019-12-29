"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    # def postorder(self, root: 'Node') -> List[int]:
    #     if not root:
    #         return []
    #     stack,res = [root],[]
    #     while stack:
    #         root = stack.pop()
    #         if root:
    #             res.append(root.val)
    #         for c in root.children:
    #             stack.append(c)
    #     return res[::-1]
    def postorder(self, root: 'Node') -> List[int]:
        res = []
        if root:
            if root.children:
                for c in root.children:
                    res.extend(self.postorder(c))
            res.append(root.val)
        return res