tion for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.res = []
    # 法1 中序遍历, 利用递归算法
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     if root:
    #         self.inorderTraversal(root.left)
    #         self.res.append(root.val)
    #         self.inorderTraversal(root.right)
    #     return self.res
    
    # 中序遍历，利用颜色标记栈迭代算法
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        WHITE, GRAY = 0, 1
        stack = [(WHITE, root)]
        res = []
        while stack:
            color, node = stack.pop()
            if node == None:
                continue
            if color == WHITE:
                stack.append((WHITE, node.right))
                stack.append((GRAY, node))
                stack.append((WHITE, node.left))
            else:
                res.append(node.val)
        return res
