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
        if (root == null) {
            return new ArrayList<>(0);
        }
        
        List<Integer> res = new ArrayList<>();
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
        return res;
    }
    
    private void dfs(List<Integer> res, TreeNode root) {
        if (root == null) {
            return;
        }
        
        dfs(res, root.left);
        res.add(root.val);
        dfs(res, root.right);
    }
}