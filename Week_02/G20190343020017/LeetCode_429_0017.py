class Solution:
    def levelOrder(self, root: 'Node') -> List[List[int]]:
        if not root:
            return []
        nodes, nextLevel, result = [root], [], []
        while nodes:
            result.append([])
            nextLevel = []
            for node in nodes:
                if node:
                    result[-1].append(node.val)
                    nextLevel += node.children
            nodes = nextLevel
        return result