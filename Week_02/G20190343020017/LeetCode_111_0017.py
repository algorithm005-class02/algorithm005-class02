class Solution:
    # 递归法
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        if root.left and not root.right:
            return self.minDepth(root.left) + 1
        if root.right and not root.left:
            return self.minDepth(root.right) + 1
        return min(self.minDepth(root.left), self.minDepth(root.right)) + 1

    # 迭代法
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        queue, level = [root], 1
        while queue:
            nextLevel = []
            for node in queue:
                if not node.left and not node.right:
                    return level
                if node.left:
                    nextLevel.append(node.left)
                if node.right:
                    nextLevel.append(node.right)
            queue, level = nextLevel, level + 1