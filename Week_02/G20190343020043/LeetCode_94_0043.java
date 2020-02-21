class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer > res = new ArrayList<>();
        travelsal(root,res);
        return res;
    }

    void travelsal(TreeNode node, ArrayList<Integer > res) {
        if (node != null) {
            if (node.left != null) {
                travelsal(node.left, res);
            }
            res.add(node.val);
            if (node.right != null) {
                travelsal(node.right, res);
            }
        }
    }
}