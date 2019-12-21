
//import	java.util.stream.Node;
//import	java.util.stream.Node;//给定一个 N 叉树，返回其节点值的后序遍历。
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

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class NAryTreePostorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePostorderTraversal().new Solution();

        Node rootChild1 = new NAryTreePostorderTraversal().new Node(2,new ArrayList<>());
        Node rootChild2 = new NAryTreePostorderTraversal().new Node(4,new ArrayList<>());

        Node child1 = new NAryTreePostorderTraversal().new Node(5,new ArrayList<>());
        Node child2 = new NAryTreePostorderTraversal().new Node(6,new ArrayList<>());
        List<Node> childs = new ArrayList<> ();
        childs.add(child1);
        childs.add(child2);
        Node rootChild3 = new NAryTreePostorderTraversal().new Node(3,childs);
        List<Node> rootChildNode = new ArrayList<> ();
        rootChildNode.add(rootChild3);
        rootChildNode.add(rootChild1);
        rootChildNode.add(rootChild2);
        Node root = new NAryTreePostorderTraversal().new Node(1,rootChildNode);
//        root.children = ;

//        rootChild3.children = childs;
        List<Integer> postorder = solution.postorder(root);
        System.out.println(postorder);

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
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }
    public void helper(Node root) {
        if(root == null) {
            return;
        }
        int s = root.children.size();
        for(int i = 0; i < s; i++) {
            helper(root.children.get(i));
        }
        res.add(root.val);
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
    