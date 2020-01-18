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
    private int[] preorder;
    private int[] inorder;
    private int preIdx = 0;
    Map<Integer, Integer> idxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;

        int inIdx = 0;
        for (int v : inorder) {
            this.idxMap.put(v, inIdx++);
        }
        return this.buildTree(0, preorder.length);
    }

    private TreeNode buildTree(int start, int end) {
        if (start == end) {
            return null;
        }

        int value = this.preorder[this.preIdx];
        TreeNode node = new TreeNode(value);
        int idx = this.idxMap.get(value);
        this.preIdx++;

        node.left = this.buildTree(start, idx);
        node.right = this.buildTree(idx + 1, end);

        return node;
    }
}