/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 */

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
 * @return {number[][]}
 */
var levelOrder = function(root) {
    if( !root ) return [];
    const stack = [root];
    const result = [];
    while (stack.length > 0) {
        const levelVals = [];
        const nodeLen = stack.length;
        for (let i = 0; i < nodeLen; i++) {
            const node = stack[i];
            levelVals.push(node.val);
            if ( node.children && node.children.length > 0 ) {
                node.children.forEach( (childNode) =>{
                    if( childNode ) {
                        stack.push(childNode);
                    }
                } );
            }
        }
        if( levelVals.length > 0 ){
            result.push(levelVals);
        }
        stack.splice(0,nodeLen);
    }

    return result;
};
// @lc code=end

