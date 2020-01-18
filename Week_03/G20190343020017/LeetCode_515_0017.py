class Solution:
    def largestValues(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        result, level = [], [root]
        while level:
            vals, nextLevel = [], []
            for node in level:
                vals.append(node.val)
                if node.left:
                    nextLevel.append(node.left)
                if node.right:
                    nextLevel.append(node.right)
            result.append(max(vals))
            level = nextLevel
        return result