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
    result = [];
    stack = [];
    otherStack = [];
    current = root;
    while (current) {
        if (current.children.length < 1 || otherStack.includes(current)) {
            result.push(current.val);
            current = stack.pop();
        }  else {
            let children = current.children;
            stack.push(current);
            otherStack.push(current);
            current = children[0];
            for (let i = children.length - 1; i > 0; i--) {
                stack.push(children[i]);
            }
        }
    }
    return result;
};