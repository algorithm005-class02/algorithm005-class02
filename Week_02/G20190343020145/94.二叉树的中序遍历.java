/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//二叉树的中续遍历递归
class Solution {
    public List < Integer > inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helpcur(res,root);
        return res;
    }

    public void helpcur(List<Integer> res,TreeNode root){
        if(root != null){
            if(root.left != null)
                helpcur(res, root.left);
            res.add(root.val);
            if(root.right != null)
                helpcur(res, root.right);
        }
    }
   
}
