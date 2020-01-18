"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        # 利用栈实现迭代方法
        if root is None:
            return []
        stack, res = [root,], []
        while stack:
            node = stack.pop()
            if node is not None:
                res.append(node.val)
            stack.extend(node.children[::-1])
        return res
