class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if not root:
            return []
        nodes, result = [root], []
        while nodes:
            vals, nextLevel = [], []
            for node in nodes:
                vals.append(node.val)
                if node.left:
                    nextLevel.append(node.left) 
                if node.right:
                    nextLevel.append(node.right)
            result.append(vals)
            nodes = nextLevel
        return result