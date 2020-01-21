class Solution {
    private TreeNode resNode;

    public Solution() {
        this.resNode = null;
    }
    private boolean resTree(TreeNode currentNode, TreeNode p, TreeNode q) {
         if (currentNode ==  null) {
             return  false;
         }
         int  left = this.resTree(currentNode.left,p,q)?1:0;
         int right = this.resTree(currentNode.right,p,q)?1:0;
         int  mid  = (currentNode  == p || currentNode == q) ? 1 : 0;
         if (left+right+mid >= 2) {
             this.resNode  = currentNode;
         }
         return (left+right+mid > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.resTree(root,p,q);
        return this.resNode;
    }
}