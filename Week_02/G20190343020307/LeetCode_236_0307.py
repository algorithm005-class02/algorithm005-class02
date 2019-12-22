# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def __init__(self):
        self.ans = None
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        def recurse_tree(current_node):
            if current_node is None:
                return False
            # 左子树递归
            left = recurse_tree(current_node.left)
            # 右子树递归
            right = recurse_tree(current_node.right)
            # 判断当前结点是否为查找结点
            mid = (current_node == p or current_node == q)
            # left right mid 三者中有两个为真
            if left + right + mid >= 2:
                self.ans = current_node
            return left or right or mid
        recurse_tree(root)
        return self.ans
