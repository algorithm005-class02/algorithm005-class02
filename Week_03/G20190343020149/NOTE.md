学习笔记
## 分治
一种递归，递归时化解为多个子问题  
分治代码模板  
```golang
func divideConquer(problem, param interface{}) {
    // recursion terminator
    if problem = nil {
        // print result
        return
    }

    // prepare data
    data := prepareData(problem)
    subproblems := splitProblem(problem, data)

    // conqure subproblems
    subresult1 := divideConquer(subproblems[0], param)
    subresult2 := divideConquer(subproblems[1], param)
    subresult3 := divideConquer(subproblems[2], param)

    // process and generate final result
    result := processFinalResult(subresult1, subresult2, subresult3)

    // revert current level states
}
```
## 贪心  
回溯：能够回退  
贪心：每一步寻求最当前优解（无全局观）  
动态规划：最优判断+回退  
  
使用贪心算法的场景  
拥有最优子结构

## 二分查找代码模板
```golang
left, right := 0, len(array)-1
for left <= right {
    mid := (left + right) / 2
    if arr[mid] == target {
        // find the target
        break or return
    } else if arr[mid] < target {
        left = mid+1
    } else {
        right = mid-1
    }
}
```
