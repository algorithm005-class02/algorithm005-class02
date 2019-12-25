class Solution:
    # 递归法
    def preorder(self, root: 'Node') -> List[int]:
        if not root:
            return []
        result = []
        result.append(root.val)
        for child in root.children:
            result += self.preorder(child)
        return result

    # 迭代法
    def preorder(self, root: 'Node') -> List[int]:
        stack, result = [root], []
        while stack and stack[-1]:
            root = stack.pop()
            result.append(root.val)
            for node in root.children[::-1]:
                stack.append(node)
        return result

    # 类似莫里斯遍历（慢了10多ms）
    def preorder(self, root: 'Node') -> List[int]:
        result = []
        while root:
            result.append(root.val)
            if root.children:
                root.children[0].children = root.children[0].children + root.children[1:] if root.children[0].children else root.children[1:]
                root = root.children[0]
            else:
                break
        return result