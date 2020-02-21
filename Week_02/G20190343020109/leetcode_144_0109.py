# Definition for a binary tree node.
class TreeNode:
    def __init__(self,x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def preorderTraversal0(self, root: TreeNode) -> List[int]:
        res = []
        def helper(root):
            if not root:
                return
                res.append(root.val)
                helper(root.left)
                helper(root.right)
            helper(root)
            return res

    def preorderTraversal1(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        stack,res = [root],[]
        while stack:
            curr = stack.pop()
            res.append(curr.val)
            if curr.right:
                stack.append(curr.right)
            if curr.left:
                stack.append(curr.left)
        return res