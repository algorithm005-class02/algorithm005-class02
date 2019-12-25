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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root == null) {
            return list;
        }
        getChilds(root, list);
        return list;
    }

    public void getChilds(TreeNode root,List<Integer> res)
    {
        if(root.left != null) {
            getChilds(root.left, res);
        }
        res.add(root.val);
        if(root.right != null) {
            getChilds(root.right, res);
        }
    }
}