"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        from collections import deque
        que = deque()
        res = []
        que.append([root])
        while que:
            nodes = que.pop()
            temp = []
            childrens = []
            for node in nodes:
                temp.append(node.val)
                if node.children:
                    childrens += node.children
            res.append(temp)
            if childrens:
                que.append(childrens)
        return res