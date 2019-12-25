#
# @lc app=leetcode.cn id=144 lang=python3
#
# [144] 二叉树的前序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 1. 递归法
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
    #     self.preorder(root, res)
    #     return res

    # def preorder(self, root: TreeNode, res: List):
    #     if root:
    #         res.append(root.val)
    #         self.preorder(root.left, res)
    #         self.preorder(root.right, res)

    # 2. 栈递归
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     stack, res = [], []
    #     while stack or root:
    #         while root:
    #             res.append(root.val)
    #             stack.append(root)
    #             root = root.left
    #         root = stack.pop()
    #         root = root.right
    #     return res

    # 3. 颜色标记法
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack, res = [(root, 0)], []
        while stack:
            node, is_visited = stack.pop()
            if not node: continue
            if is_visited:
                res.append(node.val)
            else:
                stack.append((node.right, 0))
                stack.append((node.left, 0))
                stack.append((node, 1))
        return res



# @lc code=end

