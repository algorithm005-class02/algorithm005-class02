class Solution:
    # 递归法
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        if bool(p)^bool(q):
            return False
        return (not p and not q) or (p.val == q.val and self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right))

    # 迭代法
    def isSameTree(self, p: TreeNode, q: TreeNode) -> bool:
        queue = [p, q]
        while queue:
            n = len(queue) // 2
            nextLevel = []
            for i in range(n):
                if bool(queue[i])^bool(queue[-i-1]):
                    return False
                if queue[i] and queue[-i-1]:
                    if queue[i].val != queue[-i-1].val:
                        return False
                    nextLevel.insert(0, queue[i].left)
                    nextLevel.append(queue[-i-1].left)
                    nextLevel.insert(0, queue[i].right)
                    nextLevel.append(queue[-i-1].right)
            queue = nextLevel
        return True