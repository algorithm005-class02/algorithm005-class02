import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的前序遍历
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 */
public class Leetcode_589_naryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node child : root.children) {
            helper(child, res);
        }
    }
}
