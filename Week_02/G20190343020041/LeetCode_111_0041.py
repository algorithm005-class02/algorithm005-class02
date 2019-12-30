# 给定一个二叉树，找出其最小深度。
#
# 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
#
# 说明: 叶子节点是指没有子节点的节点。
#
# 示例:
#
# 给定二叉树 [3,9,20,null,null,15,7],
#
#     3
#   / \
#  9  20
#    /  \
#   15   7
#
# 返回它的最小深度 2.
# Related Topics 树 深度优先搜索 广度优先搜索


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.
import collections


class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def minDepthDfs(self, root: TreeNode) -> int:
        if not root: return 0
        m1 = self.minDepth(root.left)
        m2 = self.minDepth(root.right)
        return m1 + m2 + 1 if m1 == 0 or m2 == 0 else min(m1, m2) + 1

    def minDepthDfs1(self, root: TreeNode) -> int:
        stack, min_depth = [(root, 1)], float('inf')
        if not root:
            return 0
        while stack:
            depth, root = stack.pop()
            if not root.left and not root.right:
                min_depth = min(min_depth, depth)
            if root.right:
                stack.append((root.right, depth + 1))
            if root.left:
                stack.append((root.left, depth + 1))
        return min_depth

    def minDepth(self, root: TreeNode) -> int:
        queue = collections.deque([(root, 1)])
        while queue:
            node, level = queue.popleft()
            if node:
                if not node.left and node.right:
                    return level
                queue.append((node.left, level + 1))
                queue.append((node.right, level + 1))
        return 0

# leetcode submit region end(Prohibit modification and deletion)
