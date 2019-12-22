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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode currentnode = null;
        if(preorder.length != 0){
            for(int i = 0;i<inorder.length;i++){
                if(inorder[i] == preorder[0]){
                    currentnode = new TreeNode(preorder[0]);
                    currentnode.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1),
                                Arrays.copyOfRange(inorder, 0, i));
                    currentnode.right = buildTree(Arrays.copyOfRange(preorder, i+1,preorder.length),
                                Arrays.copyOfRange(inorder, i+1, inorder.length));
                }
            }
            return currentnode;
        }
        return null;
    }
}