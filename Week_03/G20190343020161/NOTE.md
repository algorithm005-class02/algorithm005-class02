学习笔记

## 分治和回溯
分治法的思想：将一个大的问题拆分成多个子问题，通过解决一个个的子问题从而到解决目标问题的结果。  

回溯法的思想：回溯法是采用试错的方法来实现，它尝试分步去解决一个问题。如果发现一条路走不通，就回退，然后尝试其他的路。  

回溯法通常用最简单的递归来实现，在反复上述步骤后可能会出现下面的情况：
1. 找不到可能存在的正确答案；
2. 在尝试了所有可能的分步方法后宣告该问题没有答案；
3. 在最坏的情况下，回溯法可能导致一次时间复杂度为指数的计算；


### 分治代码模板
        
        def divide_conquer(problem, param1, param2, ...)
            # recursion terminator
            if problem is none;
                print_result
                return
            
            # prepare data
            data = prepare_data(problem)
            subproblems = split_problem(problem, data)
            
            # conquer subproblems
            subresult1 = self.divide_conquer(subproblems[0], p1, ...)
            subresult2 = self.divide_conquer(subproblems[1], p1, ...)
            subresult3 = self.divide_conquer(subproblems[2], p2, ...)
            ...
            
            # process and generate the final result
            result = process_result(subresult1, subresult2, subresult3, ...)
            
            # revert the current level states

## 深度优先搜索和广度优先搜索

### 搜索
- 每个节点都要访问一次
- 每个节点仅仅要访问一次
- 对于节点的访问顺序不限
深度优先：depth first search
广度优先：breadth first search

### 代码结构
#### 深度优先(DFS)
        
        def  dfs(node):
            if node in visited
                # already visited 
                return
             
            visited.add(node)
            
            # process curent node
            # ...
            # logic here
            dfs(node.left)
            dfs(node.right)
            
#### 广度优先(BFS)
        
        def BFS(graph, start, end)
        
            queue = []
            queue.append([start])
            visited.add(start)
            
            while queue:
                node = queue.pop()
                visited.add(node)
                
                process(node)
                nodes = generate_related_nodes(node)
                queue.push()nodes
            # other processing work
            ...
## 贪心算法
贪心算法主要理解什么叫贪心算法，它与动态规划的区别，以及贪心算法的使用场景。

### 什么是贪心算法
贪心算法是每一步都选当前最优方案，从而希望导致结果是全局最好或者最优的算法。

### 贪心算法与动态规划的区别
1. 贪心算法不能回退；
2. 动态规划则会保存以前的运算结果，并根据以前的结果对当前进行选择，有回退功能；

### 贪心算法的使用场景
问题能够分解成子问题来解决，子问题的最优解能够推到到最终问题的最优解。这种问题的最优解称之为最优子结构。


## 二分查找

### 二分查找的前提
1. 目标函数单调性（单调递增或递减） 
2. 存在上下界（bounded）
3. 能够通过索引访问（index accessible）

### 结构
        
        left, right = 0, len(array) - 1
        while left <= right:
            mid = (left + right)/2
            if array[mid] = target
                # find the target 
                break or return result
            elif array[mid] < target
                left = mid + 1
            else:
                right = mid - 1
            
            