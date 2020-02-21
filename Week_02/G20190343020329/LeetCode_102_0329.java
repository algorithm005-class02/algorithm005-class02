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

    int idx = 0;
    int[] preorder;
    int[] inorder;
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode helper(int left, int right) {
        if (left == right)
            return null;

        int value = preorder[idx];
        TreeNode root = new TreeNode(value);

        int index = map.get(value);

        idx++;

        root.left = helper(left, index);
        root.right = helper(index + 1, right);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0; i < inorder.length; i ++) {
            map.put(inorder[i], i);
        }

        return helper(0, inorder.length);
    }
}