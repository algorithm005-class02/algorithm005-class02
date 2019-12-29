//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NAryTreeLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreeLevelOrderTraversal().new Solution();
        Node rootChild1 = new NAryTreeLevelOrderTraversal().new Node(2,new ArrayList<>());
        Node rootChild2 = new NAryTreeLevelOrderTraversal().new Node(4,new ArrayList<>());

        Node child1 = new NAryTreeLevelOrderTraversal().new Node(5,new ArrayList<>());
        Node child2 = new NAryTreeLevelOrderTraversal().new Node(6,new ArrayList<>());
        List<Node> childs = new ArrayList<> ();
        childs.add(child1);
        childs.add(child2);
        Node rootChild3 = new NAryTreeLevelOrderTraversal().new Node(3,childs);
        List<Node> rootChildNode = new ArrayList<> ();
        rootChildNode.add(rootChild3);
        rootChildNode.add(rootChild1);
        rootChildNode.add(rootChild2);
        Node root = new NAryTreeLevelOrderTraversal().new Node(1,rootChildNode);
//        root.children = ;

//        rootChild3.children = childs;
        List<List<Integer>> levelOrder = solution.levelOrder(root);
        System.out.println(levelOrder);
    }
    

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
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) {
            return levels;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int level = 0;
        while ( !queue.isEmpty() ) {
            levels.add(new ArrayList<Integer>());

            // number of elements in the current level
            int level_length = queue.size();
            for(int i = 0; i < level_length; ++i) {
                Node node = queue.remove();
                levels.get(level).add(node.val);
                int len=node.children.size();
                if(len!=0){
                    for(int j=0;j<len;j++){
                        queue.add(node.children.get(j));
                    }
                }
            }
            level++;
        }
        return levels;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
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
}
    