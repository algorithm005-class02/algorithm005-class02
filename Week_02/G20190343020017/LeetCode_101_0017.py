class Solution:
    # 递归法，检查当前节点左右子树的值，然后将左右子树的左右子树分别拼成新的节点递归（左左-右右，左右-右左）
    def isSymmetric(self, root: TreeNode) -> bool:
        # terminator
        if not root:
            return True

        # process
        if root.left and root.right:
            if root.left.val == root.right.val:
                inner, outer = TreeNode(0), TreeNode(0)
                inner.left, inner.right, outer.left, outer.right = root.left.right, root.right.left, root.left.left, root.right.right
                
                # drill down
                return self.isSymmetric(inner) and self.isSymmetric(outer)
            else:
                return False
        else:
            return root.left is None and root.right is None
        
    # 迭代法，队列成对存储要检查的子树
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root:
            return True
        queue = [root.left, root.right]
        while queue:
            nextLevel = []
            for i in range(len(queue) // 2):
                if queue[i] and queue[-i-1]:
                    if queue[i].val != queue[-i-1].val:
                        return False
                    nextLevel.insert(0, queue[i].right)
                    nextLevel.append(queue[-i-1].left)
                    nextLevel.insert(0, queue[i].left)
                    nextLevel.append(queue[-i-1].right)
                elif bool(queue[i])^bool(queue[-i-1]):
                    return False
            queue = nextLevel
        return True