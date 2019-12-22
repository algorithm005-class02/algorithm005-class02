class Solution(object):
    def lowestCommonAncestor(self, root, p, q):
        
        if not root or root == p or root == q:
            return root
        else:
            left = self.lowestCommonAncestor(root.left, p, q)
            right = self.lowestCommonAncestor(root.right, p, q)
            
            if left and right: 
                return root
            elif left:
                return left
            elif right:
                return right
            else:
                return