import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class HomeWork {

    /**
     * 二叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<Integer>();
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        nodeStack.push(root);
        List<Integer> list = new ArrayList<Integer>();

        while(nodeStack.size() != 0 ){
            TreeNode node = nodeStack.pop();
            list.add(node.val);
            if(node.right != null)
                nodeStack.push(node.right);
            if(node.left != null)
                nodeStack.push(node.left);
        }

        return list;
    }

    /**
     * N叉树的前序遍历
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    public void helper(Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            if (root.children.size() != 0) {
                for (Node child : root.children) {
                    helper(child,res);
                }
            }
        }
    }
}
