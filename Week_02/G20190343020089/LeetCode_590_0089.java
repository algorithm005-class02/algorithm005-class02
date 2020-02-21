import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N叉树的后序遍历
 */

// @lc code=start
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
    
    // public List<Integer> postorder(Node root) {
    //     List<Integer> res = new ArrayList();
    //     postorder(root, res);
    //     return res;
    // }

    // private void postorder(Node node, List<Integer> res) {
    //     if (node != null) {
    //         if (node.children != null) {
    //             for (Node child : node.children) {
    //                 postorder(child, res);
    //             }
    //         }
    //         res.add(node.val);
    //     }
    // }

    // 后续遍历 栈实现，实现过程只需要注意是使用 链表输出
    public List<Integer> postorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pollLast();
            res.addFirst(cur.val);
            if (cur.children != null) {
                for (Node child : cur.children) stack.addLast(child);
            }
        }
        return res;


    }

}
// @lc code=end

