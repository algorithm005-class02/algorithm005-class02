//给定一个 N 叉树，返回其节点值的后序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其后序遍历: [5,6,3,2,4,1]. 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import cn.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
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

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null) {
                        helper(child, list);
                    }
                }
            }
            list.add(node.val);
        }
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node p = stack.pop();
            list.add(p.val);
            List<Node> children = p.children;
            for (Node child : children) {
                stack.push(child);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
