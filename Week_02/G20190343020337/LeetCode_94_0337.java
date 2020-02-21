class Solution {

    //栈实现
    public List < Integer > inorderTraversal_stack(TreeNode root) {
        List < Integer > res = new ArrayList < > ();
        Stack < TreeNode > stack = new Stack < > ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    //递归实现
    List<Integer> visited = new ArrayList<Integer>();
    public List<Integer> inorderTraversal_recursive(TreeNode root) {
        if(root!=null){
            inorderTraversal(root.left);
            visit(root);
            inorderTraversal(root.right);
        }
        return visited;
    }
    public void visit(TreeNode node){
        visited.add(node.val);
    }

}