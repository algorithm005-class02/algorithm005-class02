import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.print.attribute.standard.QueuedJobCount;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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

    //循环实现层序遍历
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (true) {
            // 每次循环进入，当层节点数等于当前队列元素数。
            if (queue.isEmpty()) break;
            List<Integer> resItem = new ArrayList<>();
            for (int i = queue.size() - 1; i >= 0; i--) {
                Node curr = queue.pollLast();
                resItem.add(curr.val);
                if (curr.children != null && curr.children.size() > 0) {
                    for (Node node : curr.children) queue.addFirst(node);
                }
            }
            res.add(resItem);
        }
        return res;
    }
}
// @lc code=end

