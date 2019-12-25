class Solution:
    # 递归
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        return [root.val] + self.preorderTraversal(root.left) + self.preorderTraversal(root.right) if root else []

    # 迭代法，类似94题思路
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack, result, cur = [], [], root
        while cur or stack:
            while cur:
                result.append(cur.val)
                stack.append(cur)
                cur = cur.left
            cur = stack.pop().right
        return result

    # 迭代法，参考官方题解
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        stack, result = [root], []
        while stack and stack[-1]:
            cur = stack.pop()
            result.append(cur.val)
            if cur.right:
                stack.append(cur.right)
            if cur.left:
                stack.append(cur.left)
        return result

    # 莫里斯遍历（官方题解的莫里斯没看明白，这个是参照94题先序遍历的莫里斯）
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        while root:
            result.append(root.val)
            if root.left:
                pre = root.left
                while pre.right:
                    pre = pre.right
                pre.right, root = root.right, root.left
            else:
                root = root.right
        return result