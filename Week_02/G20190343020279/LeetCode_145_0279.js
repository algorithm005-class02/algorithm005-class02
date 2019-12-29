/**
 * @method "正序解法"
 * @explain 先遍历左节点, 当遍历到末尾节点时记录值, 然后跳回上一层节点, 顺便让left等于null, 再遍历右节点, 同样是遍历到末尾节点时记录值, 第二次返回时, 让右节点等于null
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
var postorderTraversal = function(root) {
  let res = [], stack = [] ,curr = root
  while (curr || stack.length) {
    // 1.先遍历左节点, 
    if (curr.left) {
      stack.push(curr)
      curr = curr.left
      // 2.再遍历右节点
    } else if (curr.right) {
      stack.push(curr)
      curr = curr.right
    } else {
      // 3.当遍历到末尾节点时, 记录值
      res.push(curr.val)
      // 4.弹出栈顶层后，把顶层的左或右节点设置为null（防止死循环）
      curr = stack.pop()
      if (curr && curr.left) curr.left = null
      else if (curr && curr.right) curr.right = null
    }
  }
  return res


};
