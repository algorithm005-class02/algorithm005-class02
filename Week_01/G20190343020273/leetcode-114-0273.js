/**
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
var preorderTraversal = function(root) {

    var arr = []

    var traval = function(node){
        if(!node) return 
        arr.push(node.val)
        if(node.left){
            traval(node.left)
        }
        if(node.right){
            traval(node.right)
        }
    }
    traval(root)

    return arr 
    
};