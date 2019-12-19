class Solution:
    # 递归法
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        self._levelOrder(root, 0, result)
        return result
    
    def _levelOrder(self, root, level, result):
        # terminator
        if not root:
            return

        # process
        if level >= len(result):
            result.append([])
        result[level].append(root.val)

        # drill down
        self._levelOrder(root.left, level + 1, result)
        self._levelOrder(root.right, level + 1, result)



    # 迭代法
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result, level, index = [], [root], 0
        while level:
            result.append([])
            nextLevel = []
            for node in level:
                if node:
                    result[index].append(node.val)
                    nextLevel.append(node.left)
                    nextLevel.append(node.right)
            level, index = nextLevel, index + 1
        result.pop()
        return result