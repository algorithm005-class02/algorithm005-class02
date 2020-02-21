class Solution:
    # 递归法
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        return self.inorderTraversal(root.left) + [root.val] + self.inorderTraversal(root.right) if root else []

    # 迭代法，想到了栈，因为递归函数调用也就是栈的形式
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return []
        # 栈顶存放当前要遍历的节点，flag标记当前已操作步数，-1需要遍历左，0遍历中，1遍历右。
        stack, flag, result = [root], [-1], []
        # 只要栈中有元素
        while stack:
            if flag[-1] == -1:
                flag[-1] = 0
                if stack[-1].left:
                    stack.append(stack[-1].left)
                    flag.append(-1)
            elif flag[-1] == 0:
                flag[-1] = 1
                result.append(stack[-1].val)
            elif flag[-1] == 1:
                flag[-1] = 2
                if stack[-1].right:
                    stack.append(stack[-1].right)
                    flag.append(-1)
            else:
                stack.pop()
                flag.pop()
        return result

    # 看了题解后的迭代法，之前没想到双层循环
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack, result, cur = [], [], root
        while cur or stack:
            while cur:
                stack.append(cur)
                cur = cur.left
            cur = stack.pop()
            result.append(cur.val)
            cur = cur.right
        return result

    # 莫里斯遍历（改变了树的结构）
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        result = []
        while root:
            if root.left:
                pre = root.left
                while pre.right:
                    pre = pre.right
                pre.right, root.left, root = root, None, root.left
            else:
                result.append(root.val)
                root = root.right
        return result
    