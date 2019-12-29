/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode ans;
    public Solution(){
        this.ans = null;
    }

    public boolean findMostCommonAncestor(TreeNode currentnode, TreeNode p, TreeNode q){
        if(currentnode == null){
            return false;
        }
        int left =  findMostCommonAncestor(currentnode.left,p,q) ? 1 : 0;
        int right = findMostCommonAncestor(currentnode.right,p,q) ? 1 : 0;
        int mid = (currentnode == p || currentnode ==q) ? 1 : 0;
        if(left+right+mid >= 2){
            this.ans = currentnode;
        }
        return mid+right+left>0;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        findMostCommonAncestor(root,p,q);
        return ans;    
    }
}