# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


def preorderTraversal(self, root: TreeNode):
# if root:
#     self.traverse_path.append(root,val)
#     self.preorderTraversal(root,left)
#     self.preorderTraversal(root,right)

    res = []
    if not root:
        return res
    stack = [root]
    while stack:
        node = stack.pop()
        res.append(node.val)
        if node.right:
            stack.append(node.right)
        if node.left:
            stack.append(node.left)
    return res

    # if not root:
    #     return []
    # return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)
    #
    # def preorderTraversal(self, root: TreeNode) -> List[int]:
    #     res = []
    #     self.preorder(root, res)
    #     return res
    #
    # def preorder(self, root, res):
    #     if not root:
    #         return res
    #     res.append(root.val)
    #     self.preorder(root.left, res)
    #     self.preorder(root.right, res)
    #     return res