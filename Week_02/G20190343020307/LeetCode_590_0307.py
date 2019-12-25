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
    def postorder(self, root: 'Node') -> List[int]:
        if root is None:
            return []

        # 法1 利用递归方法
        # if root:
        #     for c in root.children:
        #         self.postorder(c)
        #     self.res.append(root.val)
        # return self.res

        # 法2 使用栈方法
        stack, res = [root,], []
        while stack:
            node = stack.pop()
            if node is not None:
                res.append(node.val)
            for c in node.children:
                stack.append(c)
        return res[::-1]
