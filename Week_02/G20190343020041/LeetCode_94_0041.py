# 给定一个二叉树，返回它的中序 遍历。
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
# 输出: [1,3,2]
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
# Related Topics 栈 树 哈希表

from typing import List


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        res = []
        self.helper(root, res)
        return res

    def helper(self, root: TreeNode, res: List[int]):
        if root:
            self.helper(root.left, res)
            res.append(root.val)
            self.helper(root.right, res)

# leetcode submit region end(Prohibit modification and deletion)
