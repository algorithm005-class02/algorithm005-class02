class Solution:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        # 前序遍历：根、左、右

        if root:
            values = list()
            values.append(root.val)
            left = self.preorderTraversal(root.left)
            if left:
                values.extend(left)
            right = self.preorderTraversal(root.right)
            if right:
                values.extend(right)
            return values
        else:
            return None