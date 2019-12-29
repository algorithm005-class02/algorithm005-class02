/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function(root) {
    // let result = [];
    // dfs(root,result);
    // return result;
    return stackWay(root)
};

// 根->左->右
function stackWay(root) {
    let result = [];
    // 这里stack应该用链表代替效率更高
    let stack = [root];
    let curNode;
    while (stack.length > 0) {
        curNode = stack.pop();
        if ( curNode ) {
            result.push(curNode.val);
            // 右边先入栈
            for (let i = curNode.children.length-1; i > -1; i--) {
                const child = curNode.children[i];
                stack.push(child)
            }
        }
    }
    return result;
}

// 递归前序遍历
function dfs(node, result) {
    if( node === null || node === undefined ) {
        return result;
    }
    result.push(node.val)
    if( node.children ) {
        node.children.forEach( (child)=>{
            dfs(child, result);
        } );
    }
}
// @lc code=end

