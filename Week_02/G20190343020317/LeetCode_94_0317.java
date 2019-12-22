class Solution {
    //递归解法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root==null){
            return result;
        }
        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }
    
    //非递归解法
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (curr!=null||!nodeStack.isEmpty()){
            while (curr!=null){
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            result.add(curr.val);
            curr = curr.right;
        }
        return result;
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        TreeNode curr = root;
        Stack<TreeNode> nodeStack = new Stack<>();
        while (curr!=null||!nodeStack.isEmpty()){
            while (curr!=null){
                nodeStack.push(curr);
                result.add(curr.val);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            curr = curr.right;
        }
        return result;
    }
    
    
}