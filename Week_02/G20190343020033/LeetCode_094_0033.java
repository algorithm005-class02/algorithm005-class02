class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.process(root,result);
        return result;
    }

    private void process(TreeNode node,List<Integer> result){
        if(node != null){
            if(node.left != null){
                this.process(node.left,result);
            }
            result.add(node.val);
            if(node.right != null){
                this.process(node.right,result);
            }
        }
    }
}