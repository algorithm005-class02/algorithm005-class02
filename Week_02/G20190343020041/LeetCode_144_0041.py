# 给定一个二叉树，返回它的 前序 遍历。
#
# 示例:
#
# 输入: [1,null,2,3]
#   1
#    \
#     2
#    /
#   3
#
# 输出: [1,2,3]
#
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# Related Topics 栈 树


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
from typing import List


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root, res)
        return res

    def helper(self, root: TreeNode, res: List[int]):
        if root:
            res.append(root.val)
            self.helper(root.left, res)
            self.helper(root.right, res)

# leetcode submit region end(Prohibit modification and deletion)
