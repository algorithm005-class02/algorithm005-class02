//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import cn.Node;
import cn.TreeNode;

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
     *
     * @param root
     * @return
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    public void helper(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            if (node.children != null) {
                for (Node child : node.children) {
                    if (child != null) {
                        helper(child, list);
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
