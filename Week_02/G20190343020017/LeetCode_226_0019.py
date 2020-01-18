class Solution:
    # 递归法
    def invertTree(self, root: TreeNode) -> TreeNode:
        if root:
            l, r = root.left, root.right
            root.left = self.invertTree(r)
            root.right = self.invertTree(l)
        return root
    
    # 迭代法
    def invertTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return
        stack = [root]
        while stack:
            temp = stack.pop()
            temp.left, temp.right = temp.right, temp.left
            if temp.left: 
                stack.append(temp.left)
            if temp.right: 
                stack.append(temp.right)
        return root