import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javafx.scene.Node;


/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    // 递归实现
    // public List<Integer> preorder(Node root) {
    //     List<Integer> res = new ArrayList<>();
    //     perorder(root, res);
    //     return res;
    // }

    // private void perorder(Node root, List<Integer> res) {
    //     if (root != null) {
    //         res.add(root.val);
    //         if (root.children != null) {
    //             for (Node child : root.children) perorder(child, res);
    //         }
    //     }
    // }

    // 循环实现
    // 这是一个使用栈实现遍历的模板，需要注意的点进栈的顺序，
    // 还是递归香
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> stack = new LinkedList<>();
        stack.addFirst(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pollLast();
            res.add(cur.val);
            if (cur.children != null) {
                for (int i = cur.children.size() -1; i >= 0 ; i--) {
                    stack.addLast(cur.children.get(i));
                }
            }
        }
        return res;
    }
}
// @lc code=end

