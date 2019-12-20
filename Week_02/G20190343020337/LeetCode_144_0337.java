class Solution {

    //栈实现
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> v = new ArrayList<>();
        TreeNode curr = root;
        while(curr!=null||!stack.isEmpty()){

            while (curr!=null){
                v.add(curr.val);
                stack.push(curr);
                curr=curr.left;
            }

            curr = stack.pop().right;


        }
        return v;

    }

    //递归实现
    List<Integer> visited = new ArrayList<Integer>();
    public List<Integer> preorderTraversal_recurrsive(TreeNode root) {
        if(root!=null){
            visited.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);
        }
        return visited;
    }
}