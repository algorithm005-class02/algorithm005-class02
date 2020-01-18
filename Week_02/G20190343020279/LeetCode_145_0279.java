/**
 * @method "递归法"
 * @explain 直截了当。我们可以定义一个辅助函数来实现递归。
 * @complexity 时间复杂度：O(n),空间复杂度：O(n)
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 1.定义一个作为返回结果的List
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        // 2.递归函数实现
        recursionMachine(root,res);
        return res;
    }


    // 3.定义一个辅助函数来实现后序遍历递归
    public void recursionMachine(TreeNode root,List<Integer> res){
        if (root != null) {
            recursionMachine(root.left,res);
            recursionMachine(root.right,res);
            res.add(root.val);
        }
    }
}


/**
 * 靠自己人肉递归死磕出来的代码，这样学算法效率低成就感高（做完后看到题目是“困难”，心里美滋滋）
 * @method "栈遍历法"
 * @explain 基于维护一个栈来实现树的遍历，后序遍历相当于向左节点方向每遍历到一个节点时都添加到栈里，当没有了之后就返回到最上面的节点（不弹出），然后接着判断这个节点有没有右节点，有的话就接续遍历右节点，遇到当前节点没有右节点时，就可以判断出已经到了左-右-根的第三个阶段，这时就可以把当前的节点值插入到返回数组中并出栈，这时要注意的是为了防止上一个节点重复进入到已出栈的右节点，可以把出栈的节点保存下来做判断，假如当前的栈顶节点的右节点存在但右节点是上一个出栈的节点时，就继续出栈和赋值到返回数组，如此不断操作直到栈变为空。
 * @complexity 时间复杂度：O(n),空间复杂度：O(n)
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        // 1.用于返回结果的数组
        List < Integer > res = new ArrayList < > ();
        // 2.用于暂存节点的栈
        Stack < TreeNode > stack = new Stack < > ();
        // 3.用于放入当前节点
        TreeNode current = root;
        // 4.用于记录最后一个出栈的节点（后面用于防止右节点的重复入栈导致死循环）
        TreeNode lastPassedNode = null;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // 5.如果当前节点不为空，则先放到栈中备用
                stack.push(current);
                // 6.拿出左节点继续遍历
                current = current.left;
            }
            // 8.如果当前节点为空则拿出栈顶的节点（不删除，这是跟前、中序二叉树用栈操作的不同）
            current = stack.peek();
            // 9.如果栈不为空则
            while (!stack.isEmpty()){
                // 10.当栈顶节点的右节点存在的时候 且 右节点并没有进入过栈的情况
                if (stack.peek().right != null && stack.peek().right != lastPassedNode) {
                    // 11.跳出出栈操作同时进入右节点
                    current = current.right;
                    break;
                } else {
                    // 12.把当前的节点值插入到返回数组中，出栈并记录下来防止重复再进入（已经到了左-右-根的第三个阶段）
                    res.add(current.val);
                    lastPassedNode = stack.pop();
                    if (!stack.isEmpty()) {
                        current = stack.peek();   
                    } else {
                        // 13.栈变空了退出
                        current = null;
                    }
                }
            }
        }
        return res;
    }
}
