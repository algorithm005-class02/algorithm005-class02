# 您需要在二叉树的每一行中找到最大的值。
#
# 示例：
#
#
# 输入:
#
#          1
#         / \
#        3   2
#       / \   \
#      5   3   9
#
# 输出: [1, 3, 9]
#
# Related Topics 树 深度优先搜索 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
from _testcapi import INT_MIN
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        queue = [root]
        res = []
        if not root:
            return res
        while queue:
            nodes = []
            m = INT_MIN
            for n in queue:
                m = max(m, n.val)
                if n.left:
                    nodes.append(n.left)
                if n.right:
                    nodes.append(n.right)
            res.append(m)
            queue = nodes
        return res

# leetcode submit region end(Prohibit modification and deletion)
