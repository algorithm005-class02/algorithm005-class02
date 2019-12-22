/*
 * @lc app=leetcode.cn id=590 lang=javascript
 *
 * [590] N叉树的后序遍历
 */

function Node(val,children) {
   this.val = val;
   this.children = children;
};

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */
/**
 * @param {Node} root
 * @return {number[]}
 */
var postorder = function(root) {
    // let result = [];
    // dfs(root, result);
    // return result;
    return stackWay(root);
};


function stackWay(root) {
    let result = [];
    // 这里stack应该用链表代替效率更高
    let stack = [root];
    let curNode;
    while (stack.length > 0) {
        curNode = stack.pop();
        if ( curNode ) {
            result = [curNode.val].concat(result);
            curNode.children.forEach( (child)=>{
                stack.push(child);
            } );
        }
    }
    return result;
}

// 递归后序遍历
function dfs(node, result) {
    if( node === null || node === undefined ) {
        return result;
    }
    if( node.children ) {
        node.children.forEach( (child)=>{
            dfs(child, result);
        } );
    }
    result.push(node.val)
}
// @lc code=end

