class Solution:
    def postorder(self, root: 'Node') -> List[int]:
        values = list()
        if root:
            if root.children:
                for i in root.children:
                    val = self.postorder(i)
                    if val:
                        values.extend(val)
                values.append(root.val)
            else:
                values.append(root.val)
            return values
        else:
            return list()