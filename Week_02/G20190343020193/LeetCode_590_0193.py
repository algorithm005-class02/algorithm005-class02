class Solution(object):
    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []
        res = list()
        for leaf in root.children:
            res += self.postorder(leaf) #先扫子树
        return res + [root.val] #再加根