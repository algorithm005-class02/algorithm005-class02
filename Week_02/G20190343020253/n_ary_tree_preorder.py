class Solution:
    def preorder(self, root: 'Node') -> List[int]:
        if root:
            values = list()
            values.append(root.val)
            if root.children:
                for i in root.children:
                    val = self.preorder(i)
                    if val:
                        values.extend(val)
            return values
        else:
            return list()