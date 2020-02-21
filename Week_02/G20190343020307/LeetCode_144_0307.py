# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     # 利用颜色标记栈法
    #     WHITE, GRAY = 0, 1
    #     stack = [(WHITE, root)]
    #     res = []
    #     while stack:
    #         color, node = stack.pop()
    #         if not node:
    #             continue
    #         if color == WHITE:
    #             stack.append((WHITE, node.right))
    #             stack.append((WHITE, node.left))
    #             stack.append((GRAY, node))
    #         else:
    #             res.append(node.val)
    #     return res

    # 法2 利用栈迭代方法
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        stack, res = [root,], []
        while stack:
            node = stack.pop()
            if node is not None:
                res.append(node.val)
            if node.right is not None:
                stack.append(node.right)
            if node.left is not None:
                stack.append(node.left)
        return res
