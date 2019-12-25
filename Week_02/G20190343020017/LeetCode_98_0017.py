class Solution:
    # 递归法
    def isValidBST(self, root: TreeNode) -> bool:
        return self._isInLimit(root, None, None)

    def _isInLimit(self, node, min, max):
        # terminator
        if not node:
            return True
        
        # process
        if min is not None and node.val <= min:
            return False
        if max is not None and node.val >= max:
            return False

        # drill down
        return self._isInLimit(node.left, min, node.val) and self._isInLimit(node.right, node.val, max)