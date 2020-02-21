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
    private List<Integer> elements = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        this.doInorder(root);
        return this.elements;
    }

    private void doInorder(TreeNode node) {
        if (node == null) {
            return;
        }
        this.doInorder(node.left);
        this.elements.add(node.val);
        this.doInorder(node.right);
    }
}