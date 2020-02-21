class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (null == root) {
            return ret;
        }
        helper(root, ret);
        return ret;
    }

    public static void helper(TreeNode node, List<Integer> ret) {
        if (node.left != null) {
            helper(node.left, ret);
        }
        ret.add(node.val);
        if (node.right != null) {
            helper(node.right, ret);
        }
    }
}
