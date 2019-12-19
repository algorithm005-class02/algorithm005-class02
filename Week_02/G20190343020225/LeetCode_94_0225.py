# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    # if root:
    #     self.inorderTraversal(root,left)
    #     self.inorderTraversal_path.append(root,val)
    #     self.inorderTraversal(root,right)

    # 使用栈
    # res = []
    # stack = []
    # cur = root
    # while cur or stack != []:
    #     while cur:
    #         stack.append(cur)
    #         cur = cur.left
    #     cur = stack.pop()
    #     res.append(cur.val)
    #     cur = cur.right
    # return res

    # 递归
    # def inorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
    #     self.helper(root, res)
    #     return res
    # def helper(self,root,res):
    #     if root:
    #         self.helper(root.left,res)
    #         res.append(root.val)
    #         self.helper(root.right,res)

    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right)