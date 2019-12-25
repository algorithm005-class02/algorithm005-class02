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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        //利用栈来实现中序遍历，需要将任一节点的左子树先入栈。越是晚遍历的，越先进栈。
        while(!stack.empty()||cur!=null){//或条件，要么栈不为空，要么当前元素不为空
            while(cur!=null){
                stack.push(cur);//
                cur = cur.left; //先把左子树全部压栈，一路往左向下到叶子节点
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;//如果有右子树，则在下一次循环会被压栈
        }
        return list;
    }
}