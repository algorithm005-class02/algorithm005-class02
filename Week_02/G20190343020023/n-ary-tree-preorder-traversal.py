"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:

    def __init__(self):
        self.res = []

    def preorder(self, root: 'Node') -> List[int]:
        self.helper(root)
        return self.res

    def helper(self, root):
        if root:
            self.res.append(root.val)
            for child in root.children:
                self.helper(child)