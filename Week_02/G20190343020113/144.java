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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) {
            return list;
        }
        visitChild(root, list);
        return list;
    }

    public void visitChild(TreeNode root, List<Integer> list){
        list.add(root.val);
        if(root.left != null) {
            visitChild(root.left, list);
        }
        if(root.right != null) {
            visitChild(root.right, list);
        }
    }
}