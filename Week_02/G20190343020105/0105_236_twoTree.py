class Solution:
    def lowestCommonAncestor(self, root, p, q):
        '''
        从根节点开始遍历树
        如果节点p和q都在右子树上，那么以右孩子为节点继续1的操作
        如果节点p和q都在左子树上，那么以左孩子为根节点继续1的操作
        如果条件2和条件3都不成立，这就意味着我们已经找到节点p和节点q的LCA了
        https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
        :param root:
        :param p:
        :param q:
        :return:
        '''
        if not root:
            return None
        if root == p or root == q:
            return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if left and right:
            return root
        return left if left else right


