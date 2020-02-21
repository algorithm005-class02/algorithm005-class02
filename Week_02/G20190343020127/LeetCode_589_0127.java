import java.util.ArrayList;
import java.util.List;

/**
  链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
  前序遍历
  */

  /*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }
    //前序遍历
    public void helper (Node root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            for (Node child : root.children) {
                helper(child, res);
            }
        }
    }
}