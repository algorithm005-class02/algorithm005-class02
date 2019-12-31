# 给定一个 N 叉树，返回其节点值的前序遍历。
#
# 例如，给定一个 3叉树 :
#
#
#
#
#
#
#
# 返回其前序遍历: [1,3,5,6,2,4]。
#
#
#
# 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


# leetcode submit region begin(Prohibit modification and deletion)
"""
# Definition for a Node.
class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children
"""
from typing import List


class Node:
    def __init__(self, val=None, children=None):
        self.val = val
        self.children = children


class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        res = []
        self.helper(root, res)
        return res

    def helper(self, root: 'Node', res):
        if root:
            res.append(root.val)
            for c in root.children:
                self.helper(c, res)

# leetcode submit region end(Prohibit modification and deletion)
