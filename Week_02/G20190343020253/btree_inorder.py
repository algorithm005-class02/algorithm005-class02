class Solution:
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        # 中序遍历：左、根、右
        # 1、递归终止条件
        # 2、处理本层逻辑
        # 3、调用下一层（传递参数）
        # 4、数据清理
        if root:
            values = list()
            left_tree = self.inorderTraversal(root.left)
            if left_tree:
                values.extend(left_tree)

            values.append(root.val)

            right_tree = self.inorderTraversal(root.right)
            if right_tree:
                values.extend(right_tree)
            return values
        else:
            return None
        
        