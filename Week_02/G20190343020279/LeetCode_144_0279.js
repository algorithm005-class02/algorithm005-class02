/**
 * @method "栈遍历法"
 * @explain 基于维护一个栈来实现树的遍历，前序遍历相当于向左节点方向每遍历到一个节点时都添加到栈里并且添加到返回数组，当没有了之后就弹出最上面的节点，然后接着判断这个节点有没有右节点，没有就继续返回上一个节点直到遍历所有的节点。
 * @complexity 时间复杂度：O(n),空间复杂度：O(n)
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var preorderTraversal = function (root) {
    // 1.用于返回结果的数组
    let res = []
    // 2.用于暂存节点的栈
    let stack = []
    // 3.用于放入当前节点
    let curr = root
    // 4.如果当前节点为空同时栈也为空则退出这个循环
    while (curr != null || stack.length != 0) {
        while (curr != null) {
            // 5.如果当前节点不为空，则先放到栈中备用
            stack.push(curr)
            // 6.把当前节点放进返回函数
            res.push(curr.val)
            // 7.拿出左节点继续遍历
            curr = curr.left
        }
        // 8.如果当前节点为空则拿出栈顶的节点
        curr = stack.pop()
        // 9.然后看看右节点
        curr = curr.right
    }
    return res
};
