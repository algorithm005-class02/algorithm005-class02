/*
 * @method "递归法"
 * @explain 直截了当。我们可以定义一个辅助函数来实现递归。
 * @complexity 时间复杂度：O(n),空间复杂度：O(n)
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
        // 1.定义一个作为返回结果的List
        List<Integer> res = new ArrayList();
        if (root == null) return res;
        // 2.递归函数实现
        recursionMachine(root,res);
        return res;
    }


    // 3.定义一个辅助函数来实现前序遍历递归
    public void recursionMachine(Node root,List<Integer> res){
        res.add(root.val);
        // 4.在执行主业务后遍历其它节点
        if (root.children != null) {
            for (Node child:root.children) {
                recursionMachine(child,res);
            }
        }
    }
}
