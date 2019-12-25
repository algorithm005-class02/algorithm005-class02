#
# @lc app=leetcode.cn id=94 lang=python3
#
# [94] 二叉树的中序遍历
#

# @lc code=start
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # 1. 递归
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
    #     self.inorder(root, res)
    #     return res
    
    # def inorder(self, root: TreeNode, res: List):
    #     if root:
    #         self.inorder(root.left, res)
    #         res.append(root.val)
    #         self.inorder(root.right, res)

    # 2. 栈遍历
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     stack, res = [], []
    #     while root or stack:
    #         while root:
    #             stack.append(root)
    #             root = root.left
    #         root = stack.pop()
    #         res.append(root.val)
    #         root = root.right
    #     return res

    # 3. 颜色标记
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack, res = [(root, 0)], []
        while stack:
            node, is_visited = stack.pop()
            if not node: continue
            if is_visited:
                res.append(node.val)
            else:
                stack.append((node.right, 0))
                stack.append((node, 1))
                stack.append((node.left, 0))
        return res

        
# @lc code=end

