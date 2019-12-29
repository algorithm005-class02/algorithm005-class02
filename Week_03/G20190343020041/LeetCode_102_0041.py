# 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
#
# 例如:
# 给定二叉树: [3,9,20,null,null,15,7],
#
#     3
#   / \
#  9  20
#    /  \
#   15   7
#
#
# 返回其层次遍历结果：
#
# [
#  [3],
#  [9,20],
#  [15,7]
# ]
#
# Related Topics 树 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        """
        dfs
        """
        if not root:
            return []
        queue = [root]
        res = []
        while queue:
            child = []
            node = []
            for q in queue:
                if q:
                    child.append(q.val)
                    if q.left:
                        node.append(q.left)
                    if q.right:
                        node.append(q.right)
            queue = node
            res.append(child)
        return res

# leetcode submit region end(Prohibit modification and deletion)
