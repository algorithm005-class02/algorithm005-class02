class Solution:

    def preorderTraversal(self, root):
        """栈"""
        path = []
        stack = [root]
        while stack:
            node = stack.pop()
            if node:
                path.append(node.val)
                stack.append(node.right)
                stack.append(node.left)
        return path

    def preorder_traversal(self, root):
        """递归"""
        path = []
        self.helper(root, path)
        return path

    def helper(self, root, path):
        if root:
            path.append(root.val)
            self.helper(root.left, path)
            self.helper(root.right, path)