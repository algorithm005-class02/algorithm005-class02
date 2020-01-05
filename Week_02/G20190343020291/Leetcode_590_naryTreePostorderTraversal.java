import java.util.ArrayList;
import java.util.List;

/**
 * N叉树的后序遍历
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/
 */
public class Leetcode_590_naryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(Node root, List<Integer> res) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            helper(child, res);
        }
        res.add(root.val);
    }

}
