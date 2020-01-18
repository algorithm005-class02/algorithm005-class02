# 第三周
## 分治
### 核心思想
> 将原问题划分为n 个规模小，并且结构与原问题相似的子问题，通过递归地解决这些子问题，然后将结果合并，就得到了原问题的解。

### 使用分治的条件
1. 子问题具有相同的模式
2. 子问题可以独立求解，子问题间没有相关性（与动态规划的明显区别）
3. 具有分解终止条件（递归的终止条件）
4. 子问题合并的操作复杂度不能太高


### 代码模板

1. 递归终止判断
2. 将当前层的问题分解成子问题
3. 解决下一层的子问题
4. 组装子问题的结果
5. 清理当前层的数据

```python
def divide_conquer(problem, param1, param2,...):
    # recursion terminator
    if problem is None:
        print_result
        return
    
    # prepare data
    data = prepare_data(problem)
    subproblems = split_problem(problem, data)
    
    # conquer subproblems
    subresult_1 = self.divide_conquer(subproblems[0], p1, ...)
    subresult_2 = self.divide_conquer(subproblems[1], p1, ...)
    subresult_3 = self.divide_conquer(subproblems[2], p1, ...)
    ...
    
    # process and generate the final result
    result = process_result(subresult_1, subresult_2, subresult_3, ...)
    
    # revert the current level states
```

## 回溯
将问题的解映射成树结构，每次求解的时候，在节点选一个路线进行查找，如果发现此路不通（解不符合条件），则回退到上一个节点，换一个路线继续查找。

> 通过递归实现回溯时，是通过**有条件的**去执行递归进行的。只有符合条件的情况下，才执行递归求解。每当递归终止的时候，就是找到了一个合法的解。此时递归的返回，就会自动回溯到上一个符合条件的分叉点，再次进行求解，直到所有解均被找出为止。

所谓的回溯，是递归函数栈的回溯，而不是自己编写代码来实现回溯。

### 实现要点

* 递归的终止条件
* 每层递归时的合法性判断条件
* 注意每一次在当前层次，调用下一层的时候，应该传递什么下去，得到什么返回。

用 [括号生成问题](https://leetcode-cn.com/problems/generate-parentheses/)整理一次回溯法的重要思路：

```python
class Solution:
    def __init__(self):
        self.result = list()

    def generateParenthesis(self, n: int) -> List[str]:
        left = 0
        right = 0
        s = ""
        self.generate(left, right, n, s)
        return self.result
    
    def generate(self, left, right, n, s):
        # 递归终止条件
        if left == n and right == n:
            self.result.append(s)   # 终止时获得一个有效解
            return None

        if left < n:        # 本层递归处理逻辑
            s1 = s + "("    # 左括号只要不超过n，随时可以添加
            self.generate(left+1, right, n, s1) # 调用下一层
        
        if right < left:    # 右括号只要个数少于左括号，就可以添加
            s2 = s + ")"
            self.generate(left, right+1, n, s2)
        return None
```

第一次看到这个解题思路的时候，会觉得“加左括号”的变量 s1 并没有传递给下一步“加右括号”的操作，s2 这个变量没有从 s1 获得添加的“(”。这样处理怎么会得到题解？
正确的理解方式是：这里的左、右括号的累加不是在**同一层**操作中完成的，而是通过递归的传递完成的。s1 加了“（”之后，通过递归调用将值传递给到下一层去添加“）”。通过递归的传递完成了左、右括号的累加。

## 深度优先搜索
### 代码模板    

#### 二叉树

```python
def dfs(node):
 if node in visited:
    # already visited
    return 
    
    visited.add(node)
    
    # process current logic
    dfs(node.left)
    dfs(node.right)
    
```

#### N 叉树

```python

visited = set()

def dfs(node, visited):
    if node in visited: # terminator
        return
        
    visited.add(node)
    
    # current node logic
    
    for next_node in node.children():
        if not next_node in visited:
            dfs(next_node, visited)

```

## 广度优先搜索

使用队列

```python
def bfs(graph, start, end):
    queue = []
    queue.append([start])
    visited.append(start)
    
    while queue:
        node.queue.pop(0)
        visited.add(node)
        
        process(node)
        nodes = generate_related_nodes(node)
        queue.append(nodes)
```


## 贪心算法
在每一步中都选择当下最优解。从而希望达到全局最优。
实际上不一定会有这个效果
动态规划与此的不同点在于，动态规划会保存以前的运算结果，将现在的结果与之前结果对比进行最优选择，可以回退。

