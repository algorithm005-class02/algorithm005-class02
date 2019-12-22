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

    def levelOrder(self, root: 'Node') -> List[List[int]]:
        self.helper(root)
        return self.res

    def helper(self, root, level = 0):
        if root:
            if len(self.res) == level:
                self.res.append([])
            self.res[level].append(root.val)
            for child in root.children:
                self.helper(child, level + 1)
