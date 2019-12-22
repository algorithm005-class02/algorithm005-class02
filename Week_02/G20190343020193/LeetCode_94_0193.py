class Solution(object):
    def inorderTraversal(self, root):
  
        result = list() 
        self.generate(root, result)
        return result
 
    def generate(self, root, result):
        
        if not root:
            return 
        
        if root.left:#左
            self.generate(root.left, result)
            
        result.append(root.val)#根
 
        if root.right:
            self.generate(root.right, result)#右