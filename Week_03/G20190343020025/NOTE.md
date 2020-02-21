学习笔记

## bfs 和 dfs 的 PHP 代码模版
```
    /**
     * bfs
     * 一个简单的广度优先搜索迭代实现。
     * 1.从一个节点开始，将其加入队列并标记为已访问。
     * 2.在队列上有节点时执行此操作：
     *   *a 使下一个节点出队。
     *   *b。如果这是我们想要的，则返回true！
     *   *C。搜索邻居，如果还没有去过的话，
     *   *将它们添加到队列中并标记为已访问。
     * 3.如果找不到节点，则返回 false。
     */
    function bfs($graph, $start, $end)
    {
        $queue = new SplQueue();
        $queue->enqueue($queue); // 向队列添加元素
        $visited = [$start];
        while ($queue->count() > 0) {
            $node = $queue->dequeue(); // 从队列中取出节点
            // 找到了我们想要的
            if ($node === $end) {
                return true;
            }
            foreach ($graph[$node] as $neighbour) {
                if (!in_array($neighbour, $visited)) {
                    $visited[] = $neighbour;
                    $queue->enqueue($neighbour);
                }
            };
        }
        return false;
    }

    // 与bfs（）相同，只不过它返回路径而不是返回布尔值。
    function bfs_path($graph, $start, $end)
    {
        $queue = new SplQueue();
        # Enqueue the path
        $queue->enqueue([$start]);
        $visited = [$start];
        while ($queue->count() > 0) {
            $path = $queue->dequeue();
            # Get the last node on the path
            # so we can check if we're at the end
            $node = $path[sizeof($path) - 1];

            if ($node === $end) {
                return $path;
            }
            foreach ($graph[$node] as $neighbour) {
                if (!in_array($neighbour, $visited)) {
                    $visited[] = $neighbour;
                    # Build new path appending the neighbour then and enqueue it
                    $new_path = $path;
                    $new_path[] = $neighbour;
                    $queue->enqueue($new_path);
                }
            };
        }
        return false;
    }
```

    分治：将一个难以直接解决的大问题，分割成一些规模较小的相同问题，以便各个击破，分而治之
    分治法所能解决的问题一般具有以下几个特征：
        1) 该问题的规模缩小到一定的程度就可以容易地解决
        2) 该问题可以分解为若干个规模较小的相同问题，即该问题具有最优子结构性质。
        3) 利用该问题分解出的子问题的解可以合并为该问题的解；
        4) 该问题所分解出的各个子问题是相互独立的，即子问题之间不包含公共的子子问题。


    回溯算法：回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，
             当发现已不满足求解条件时，就 “回溯” 返回，尝试别的路径。
    回溯算法的基本思想是：从一条路往前走，能进则进，不能进则退回来，换一条路再试。归去来兮

    贪心算法：局部最优解
    贪心算法是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。
    贪心算法：不是对所有问题都能得到整体最优解，关键是贪心策略的选择，局部最优解。

    二分查找：数据结构必须先排好序。
    二分查找也称折半查找（Binary Search），它是一种效率较高的查找方法，前提是数据结构必须先排好序，可以在数据规模的对数时间复杂度内完成查找。
```
    $arr = array(1, 2, 3, 4, 5); 
    $value = 3; 
    function binarySearch($arr, $x) 
    { 
        // check for empty array 
        if (count($arr) === 0) return false; 
        $low = 0; 
        $high = count($arr) - 1; 
        while ($low <= $high) { 
            // compute middle index 
            $mid = floor(($low + $high) / 2); 
            // element found at mid 
            if($arr[$mid] == $x) { 
                return true; 
            } 
            if ($x < $arr[$mid]) { 
                // search the left side of the array 
                $high = $mid -1; 
            } else { 
                // search the right side of the array 
                $low = $mid + 1; 
            } 
        } 
        return false; 
    } 
```