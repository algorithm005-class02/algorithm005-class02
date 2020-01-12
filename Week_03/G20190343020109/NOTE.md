    学习笔记

    第三周算法学习

    本周学习安排：
    1.分治，回溯
        1.1 本质上是一种递归，算是递归的一种细分类，还是分解成子问题，找重复性
        1.2 递归和分治分别的代码模板，可以看出其中的异同
            相同点：
            1.2.1 都要有终止条件
            1.2.2 函数自己调用自己
            不同点：
            1.2.3 递归把问题分解成了规模更小，但是性质相同的子问题。只需要关注如何把原问题分解成符合条件的子问题，而不需要去研究如何解决子问题（注意，这里就是老师说的不要人肉递归，因为你不需要去关注，否则人脑能压几个栈啊）
                递归和枚举的区别在于，枚举也就是穷举，是横向划分问题。递归是把问题逐级分解，是纵向解决问题。
                递推和递归的区别在于，递推属于正向思考问题，一步一步解决问题，得到答案，递归属于逆向思维，要求我们看到问题的终点，把解决问题
                分治算法中比较典型的算法：归并排序。分治算法三步走，分解->解决->合并(回溯)，和下面给出的代码模板一样。

    递归简洁版代码模板：
    def recursion(p1):
        if(终止条件):return 最小子问题的解
        return recursion(缩小数据规模)  # 公式(数学归纳法在递归中的应用)

    递归代码模板:
    def recursion(level,p1,p2,...):
        # recursion terminator
        if level > MAX_LEVEL:
            process_result
            return
        
        # prcess logic in current level
        process(level,data...)

        # dirll down
        self.recursion(level+1,p1,p2,...)

        # reverse the current level status if needed

    分治简洁版- 归并排序代码模板：
    def merge_sorted(一个数组):
        if (终止条件):return
        merge_sorted(左边的数组)
        merge_sorted(右边的数组)
        merge(左边数组，右边数组)

    分治代码模板：
    def divide_conquer(problem,p1,p2,...):
        # recursion terminator
        if problem is None:
            print_result
            return
        
        # prepare data
        data = perpare_data(problem)
        subproblems = split_problem(problem,p1,p2,...)

        # conquer subproblems
        subresult1 = self.divide_conquer(subproblems[0],p1,p2,...)
        subresult2 = self.divide_conquer(subproblems[1],p1,p2,...)
        subresult3 = self.divide_conquer(subproblems[2],p1,p2,...)
        ...

        # process and genrate the final result
        result = process_result(subresult1, subresult2, subresult3)

        # revert the current level states   


    2.深度优先搜索，广度优先搜索
    DFS，BFS 
    1.理解搜索节点时候的遍历顺序
    2.固化的代码模板，达到熟练

    二叉树DFS代码模板：
    def dfs(node):
        # terminator
        if node is visited:
            return
        
        visited.add(node)

        # process current node
        # ... # logic here
        dfs(node.left)
        dfs(node.right)

    多叉树DFS代码模板-递归版本：
    #系统自动维护了一个栈，就是函数的调用栈 
    visited = set()
<<<<<<< HEAD
    def def(node, visited):
        # terminator
        if node is visited:
            # already visited
            return

        visited.add(node)

        # process current node here.
        ...
        for next_node in node.children():
            if not next_node in visited:
                dfs(next_node,visited)

    多叉树DFS代码模板-非递归版本:
    #手动维护一个栈，可以在纸上模拟一下 
    def DFS(self, tree):
        if tree.node is None:
            return []
        
        visited,stack = [],[tree.root]

        while stack:
            node = stack.pop()
            visited.add(node)

            process(node)
            nodes = generate_related_nodes(node) # 生成相关节点
            stack.push(nodes)

    BFS代码模板:
    #使用队列，在python中用数组表示，或者collections中的deque，在java中使用一个双端队列或者deque来表示
    def BFS(graph,start,end):
        visited = set()
        queue = []
        queue.append([start])
        
        while queue:
            node = queue.pop()
            visited(node)

            process(node)
            nodes = generate_related_nodes(node) # 生成相关节点
            queue.push(nodes)

    3.贪心算法
    贪心：当下做局部最优判断
    回溯：能够回退
    动态规划：最优判断+回退


    4.二分查找
    目标函数单调性（单调递增或单调递减）
    存在上下界
    可以通过索引访问元素

    #二分查找代码模板
    def binary_search(array,target):
        left,right = 0,len(array)-1
        while left <= right:
            mid = (left+right)/2
            if array[mid] == target:
                # find the target
                break or return result
            elif array[mid] < target:
                left = mid + 1
            else:
                right = mid - 1
=======
    queue = []
    queue.append([start])
    
    while queue:
        node = queue.pop()
        visited(node)

        process(node)
        nodes = generate_related_nodes(node) # 生成相关节点
        queue.push(nodes)

3.贪心算法
贪心：当下做局部最优判断
回溯：能够回退
动态规划：最优判断+回退


4.二分查找
目标函数单调性（单调递增或单调递减）
存在上下界
可以通过索引访问元素

#二分查找代码模板
def binary_search(array,target):
    left,right = 0,len(array)-1
    while left <= right:
        mid = (left+right)/2
        if array[mid] == target:
            # find the target
            break or return result
        elif array[mid] < target:
            left = mid + 1
        else:
            right = mid - 1



Week04 第四周NOTE
vscode 配置 Remote-ssh
vscode 配置 git git-hub
两种配置都是采用公私钥的方式，各自配置到对应服务器的authorized_keys 和 github的 settings -> ssh
>>>>>>> 99ae75538e407793800952f6cbecce28203a9d68
