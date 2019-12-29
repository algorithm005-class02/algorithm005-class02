class Solution:
    # 递归法
    def maxDepth1(self, root) -> int:
        # terminator
        if not root:
            return 0

        # process, drill down
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

    # 迭代法
    def maxDepth(self, root) -> int:
        result, stack = 0, [(root, 1)]
        while stack:
            root, depth = stack.pop()
            if root:
                result = max(result, depth)
                stack.append((root.left, depth + 1))
                stack.append((root.right, depth + 1))
        return result