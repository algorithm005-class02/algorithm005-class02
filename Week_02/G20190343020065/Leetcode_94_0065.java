class Solution {
    public List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            //Left
            if (root.left != null) {
                inorderTraversal(root.left);
            }
            //Middle
            res.add(root.val);
            //Right
            if (root.right != null) {
                inorderTraversal(root.right);
            }
        }
        return res;
    }
}
