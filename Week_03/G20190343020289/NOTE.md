学习笔记

# 回溯
[回溯算法优秀讲解](https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/)

回溯算法框架
```cassandraql
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```

多叉树的遍历
```cassandraql
void traverse(TreeNode root) {
    for (TreeNode child : root.childern)
        // 前序遍历需要的操作
        traverse(child);
        // 后序遍历需要的操作
}
```

# 深度优先，广度优先

题目 102. 二叉树的层次遍历 引用广度优先算法，并需要在广度优先中区分层次

这里注意，广度优先使用的是遍历，而不是迭代（可以思考迭代与深度优先）