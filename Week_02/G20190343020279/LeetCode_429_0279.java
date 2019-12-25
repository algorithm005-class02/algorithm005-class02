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
    public List<List<Integer>> levelOrder(Node root) {
        // 1.定义一个作为返回结果的List
        List<List<Integer>> res = new ArrayList();
        if (root == null) return res;
        // 2.递归函数实现
        recursionMachine(root,0,res);
        return res;
    }


    // 3.定义一个辅助函数来实现前序遍历递归,层序遍历比其它一般遍历多出depth来判断是哪一层（升维）
    public void recursionMachine(Node root,int depth,List<List<Integer>> res){
        // 4.判断是否是新的一层
        if (depth + 1 > res.size()) {
            res.add(new ArrayList());
        }
        res.get(depth).add(root.val);
        // 4.在执行主业务后遍历其它节点
        for (Node child : root.children) {
            recursionMachine(child,depth + 1,res);
        }
    }
}
