class Solution:
    # 递归法
    def maxDepth(self, root: TreeNode) -> int:
        # terminator
        if not root:
            return 0

        # process, drill down
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1

    # 迭代法
    def maxDepth(self, root: TreeNode) -> int: