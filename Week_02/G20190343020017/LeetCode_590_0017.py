class Solution:
    # 递归法
    def postorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        result = []
        for child in root.children:
            result += self.postorder(child)
        result.append(root.val)
        return result

    # 迭代法（参照题解，按照前序遍历的迭代然后反转过来）
    def postorder(self, root: 'Node') -> List[int]:
        stack, result = [root], []
        while stack and stack[-1]:
            root = stack.pop()
            result.append(root.val)
            for node in root.children:
                stack.append(node)
        return result[::-1]
