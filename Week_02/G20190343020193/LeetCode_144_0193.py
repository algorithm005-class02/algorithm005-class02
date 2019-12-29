class Solution(object):
    def preorderTraversal(self, root):

        if not root:
            return []
        return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right)