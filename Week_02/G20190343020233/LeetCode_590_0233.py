class Solution:

    def postorder(self, root):
        path = []
        self.helper(root, path)
        return path

    def helper(self, root, path):
        if root:
            for child in root.children:
                self.helper(child, path)
            path.append(root.val)
        return path

    def post_order(self, root):
        """抄了一遍但没看懂"""
        if not root: return []
        stack, counter, path = [root], [0], []
        while stack:
            while counter[-1] < len(stack[-1].children):
                stack.append(stack[-1].children[counter[-1]])
                counter.append(0)
            path.append(stack.pop().val)
            counter.pop()
            if len(counter) != 0:
                counter[-1] += 1
        return path

