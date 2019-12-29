#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#
# https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
#
# algorithms
# Medium (62.63%)
# Likes:    182
# Dislikes: 0
# Total Accepted:    56.5K
# Total Submissions: 89.8K
# Testcase Example:  '[1,null,2,3]'
#
# 给定一个二叉树，返回它的 前序 遍历。
#
# 示例:
#
# 输入: [1,null,2,3]
# ⁠  1
# ⁠   \
# ⁠    2
# ⁠   /
# ⁠  3
#
# 输出: [1,2,3]
#
#
# 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
#
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        ans = []

        def helper(root):
            if not root:
                return

            ans.append(root.val)
            helper(root.left)
            helper(root.right)
        helper(root)
        return ans

# @lc code=end
