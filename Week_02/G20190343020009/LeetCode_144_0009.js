var preorderTraversal = function (root) {
  // 第一步 终止条件
  if (!root) {
    return []
  } else {
    // 第二步 当前层逻辑
    // 第三步 进入下一层
    return [root.val, ...preorderTraversal(root.left), ...preorderTraversal(root.right)]
  }
};