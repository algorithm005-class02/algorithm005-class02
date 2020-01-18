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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;//如果root和目标节点一致直接返回
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null) return null;//如果左右都没有目标节点，则将null返回
        if(left!=null&&right!=null) return root;//如果左右分别发现目标节点，则返回root
        return left==null ? right : left;//如果只有单边有目标节点，则返回子树的结果
    }
}