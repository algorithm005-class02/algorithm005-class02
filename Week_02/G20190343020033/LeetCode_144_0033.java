class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        this.process(root,result);
        return result;
    }

    private void process(TreeNode node,List<Integer> result){
        if(node != null){
            result.add(node.val);
            if(node.left != null){
                this.process(node.left,result);
            }
            if(node.right != null){
                this.process(node.right,result);
            }
        }
    }
}