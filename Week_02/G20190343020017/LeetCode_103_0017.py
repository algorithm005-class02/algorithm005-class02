class Solution:
    # 递归法
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        result = []
        self._zigzagLevelOrder(root, 0, result)
        return result
    
    def _zigzagLevelOrder(self, root, level, result):
        # terminator
        if not root:
            return

        # process
        if level >= len(result):
            result.append([])
        if level % 2:
            result[level].insert(0, root.val)
        else:
            result[level].append(root.val)

        # drill down
        self._zigzagLevelOrder(root.left, level + 1, result)
        self._zigzagLevelOrder(root.right, level + 1, result)



    # 迭代法
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        result, level, index = [], [root], 0
        while level:
            result.append([])
            nextLevel = []
            for node in level:
                if node:
                    if index % 2:
                        result[index].insert(0, node.val)
                    else:
                        result[index].append(node.val)
                    nextLevel.append(node.left)
                    nextLevel.append(node.right)
            level, index = nextLevel, index + 1
        result.pop()
        return result