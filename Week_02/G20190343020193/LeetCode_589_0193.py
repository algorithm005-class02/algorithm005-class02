class Solution(object):
    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return list()
        result = list()
        result.append(root.val)#先根
        
        for leaf in root.children:
            result += self.preorder(leaf) #再扫子树
        return result