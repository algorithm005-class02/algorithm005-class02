import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        Queue<Node> currentQueue = new LinkedList<>();
        currentQueue.add(root);
        while (!currentQueue.isEmpty()) {
            List<Integer> levelData = new ArrayList<>();
            Queue<Node> nextQueue = new LinkedList<>();
            while (!currentQueue.isEmpty()) {
                Node node = currentQueue.poll();
                levelData.add(node.val);
                if (null != node.children) {
                    nextQueue.addAll(node.children);
                }
            }
            result.add(levelData);
            currentQueue = nextQueue;
        }
        return result;
    }
}