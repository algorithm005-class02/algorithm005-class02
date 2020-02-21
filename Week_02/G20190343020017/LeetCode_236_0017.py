class Solution:
    # 递归法
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        return self.find(root, p, q)

    def find(self, node, p, q):
        # terminator
        if not node:
            return 0

        # process
        mid = 1 if node == q or node == p else 0
        l, r = 0, 0

        # drill down
        if node.left:
            l = self.find(node.left, p, q)
        if isinstance(l, TreeNode):
            return l
        if node.right:
            r = self.find(node.right, p, q)
        if isinstance(r, TreeNode):
            return r

        return node if mid + l + r == 2 else mid + l + r