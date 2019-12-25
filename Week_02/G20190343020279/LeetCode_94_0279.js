/**
 * @method "栈遍历法"
 * @explain 基于维护一个栈来实现树的遍历，中序遍历相当于先把所有的最左边的节点都添加到栈里，当没有了之后就弹出最上面的节点，把这个节点的值加入到返回的数组，然后接着判断这个节点有没有右节点，没有就继续返回上一个节点直到遍历所有的节点。
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
var inorderTraversal = function(root) {
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
            // 6.拿出左节点继续遍历
            curr = curr.left
        }
        // 7.如果当前节点为空则拿出栈顶的节点
        curr = stack.pop()
        // 8.拿出后第一时间加入到返回结果的数组中
        res.push(curr.val)
        // 9.然后看看右节点
        curr = curr.right
    } 
    return res
};
