class Solution:
    def preorder(self, root):
        """这个写法越来越熟练了"""
        path = []
        self.helper(root, path)
        return path

    def helper(self, root, path):
        if root:
            path.append(root.val)
            for child in root.children:
                self.helper(child, path)
        return path

    def preorder_stack(self, root):
        stack, path = [root], []
        while stack:
            node = stack.pop()
            if node:
                path.append(node.val)
                for i in range(len(node.children) - 1, -1, -1):
                    stack.append(node.children[i])
        return path