"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        # 广度优先算法     
        if root is None:
            return []
        # 保存同一层结点,初始化为 root
        queue = [root,]
        # 保存结果
        res = []
        while queue:
            # 同一层结点的所有值
            vals = []
            # 下一层结点
            next_nodes = []
            for c in queue:
                vals.append(c.val)
                next_nodes.extend(c.children)
            res.append(vals)
            # queue 赋值下一层结点
            queue = next_nodes
        return res
