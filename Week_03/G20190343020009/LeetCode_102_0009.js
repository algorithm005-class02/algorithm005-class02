/* 思路 
一 按层分 就是BFS的思路 需要把结果一层一层的输出 就是 输出完成再入队
二 DFS也能做 递归的时候 本身每个节点都带着当前层的信息
 */

// BFS
// var levelOrder = function (root) {
//   if (!root) return [];

//   let res = []; // 存放遍历结果
//   let currentLevel = [root]
//   let nextLevel = [] // 下一层要处理的

//   // 一层循环结束再进行下一层
//   // 直到没有下一层
//   // 这个循环结束的标识要思考下  经验  循环结束标识没有可以先放一放
//   while (currentLevel.length + nextLevel.length > 0) {
//     // 对于每一层
//     let currentRes = []
//     while (currentLevel.length) {
//       const front = currentLevel.shift()
//       currentRes.push(front.val)
//       if (front.left) nextLevel.push(front.left);
//       if (front.right) nextLevel.push(front.right);
//     }
//     // 当前层空了 把结果放进去 并清空
//     res.push(currentRes)
//     currentRes = []
//     // 下一层变成当前层并清空
//     currentLevel = nextLevel
//     nextLevel = []
//   }
//   return res;
// }

/* DFS
思路 DFS刚好是从左到右的 所以最后结果的子项的顺序是正确的
这个题适合BFS 但是为了训练一下DFS 还是强行来用一用
 */
var levelOrder = function (root) {
  if (!root) return []

  const visited = new Set()
  const level = 0
  const res = []
  function DFS(node, level) {
    // 终结
    if (visited.has(node)) return
    
    // 当前层
    visited.add(node)
    if (!res[level]) res[level] = []
    res[level].push(node.val)
    
    // 下探
    const currentLevel = level + 1
    if (node.left) DFS(node.left, currentLevel)
    if (node.right) DFS(node.right, currentLevel)
  }
  DFS(root, level)

  return res
}