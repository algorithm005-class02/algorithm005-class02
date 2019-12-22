class Solution {
    public List<Integer> preorderTraversal(TreeNode, root) {
        List<Integer> ret = new ArrayList<>();
        if (null == root) {
            return ret;
        }
        helper(root, ret);
        return ret;
    }

    public static void helper(TreeNode node, List<Integer> ret) {
        ret.add(node.val);
        if (node.left != null) {
            helper(node.left, ret);
        }
        if (node.right != null) {
            helper(node.right, ret);
        }
    }
}
