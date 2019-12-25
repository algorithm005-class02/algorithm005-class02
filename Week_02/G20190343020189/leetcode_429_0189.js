// 429. N-ary Tree Level Order Traversal

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
    if (!root) return [];
    
    let results = [];
    let q = [root];
    let index = 0;
    
    while (index < q.length) {
        let levelNodes = [];
        for (let j = q.length; index < j; index++) {
            let curNode = q[index];
            curNode.children.forEach(childNode => q.push(childNode));
            levelNodes.push(curNode.val);
        }
        
        results.push(levelNodes);
    }
    
    return results;
};