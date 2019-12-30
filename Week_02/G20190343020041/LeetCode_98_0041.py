# 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
#
# 假设一个二叉搜索树具有如下特征：
#
#
# 节点的左子树只包含小于当前节点的数。
# 节点的右子树只包含大于当前节点的数。
# 所有左子树和右子树自身必须也是二叉搜索树。
#
#
# 示例 1:
#
# 输入:
#    2
#   / \
#  1   3
# 输出: true
#
#
# 示例 2:
#
# 输入:
#    5
#   / \
#  1   4
#      / \
#     3   6
# 输出: false
# 解释: 输入为: [5,1,4,null,null,3,6]。
#      根节点的值为 5 ，但是其右子节点值为 4 。
#
# Related Topics 树 深度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:

    def isValidBSTMidOrder(self, root: TreeNode) -> bool:
        last = TreeNode(float('-inf'))

        def helper(node: TreeNode):
            if not node:
                return True
            if not helper(node.left):
                return False

            if last.val >= node.val:
                return False

            last.val = node.val
            return helper(node.right)

        return helper(root)

    def isValidBST(self, root: TreeNode) -> bool:
        last = TreeNode(float('-inf'))
        stack = []
        while stack or root:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            if root.val <= last:
                return False
            last = root.val
            root = root.right
        return True

    def isValidBST1(self, root: TreeNode) -> bool:
        def helper(node: TreeNode, lower=float('-inf'), upper=float('inf')):
            if not node:
                return True
            val = node.val
            if val <= lower or val >= upper:
                return False
            return helper(node.left, lower, val) and helper(node.right, val, upper)

        return helper(root)

# leetcode submit region end(Prohibit modification and deletion)
