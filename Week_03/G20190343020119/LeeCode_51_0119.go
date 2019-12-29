func solveNQueens(n int) [][]string {
    if n <= 0 {
        return nil
    }

    if n == 1 {
        return [][]string{{"Q"}}
    }

    // 3个辅助判断表
    col := make([]bool, n)      // 竖
    dia1 := make([]bool, 2*n-1) // 撇
    dia2 := make([]bool, 2*n-1) // 捺
    arr := make([]int, n)       // arr[i]=j,表示皇后在i行j列位置
    res := [][]string{}         // 摆放结果

    putQueen(n, 0, col, dia1, dia2, arr, &res)

    return res
}

// 函数功能: 尝试在一个n皇后问题中,摆放curI行的皇后位置
func putQueen(n, curI int, col, dia1, dia2 []bool, arr []int, res *[][]string) {

    // 递归终止条件
    if curI == n {
        //generateBoard(arr): 根据arr生成相应的棋盘结果
        *res = append(*res, generateBoard(arr))
    } else {
        // 递归过程
        // curI行的n个位置均尝试摆放
        for y := 0; y < n; y++ {
            if !col[y] && !dia1[curI+y] && !dia2[curI-y+n-1] {
                arr[curI] = y

                col[y] = true
                dia1[curI+y] = true
                dia2[curI-y+n-1] = true

                // 尝试在下一行摆放皇后
                putQueen(n, curI+1, col, dia1, dia2, arr, res)

                // 使用完重置为false
                col[y] = false
                dia1[curI+y] = false
                dia2[curI-y+n-1] = false
            }
        }
    }
}

// 生成结果表
func generateBoard(arr []int) (buf []string) {
    n := len(arr)
    for i := 0; i < n; i++ {
        var str string
        for j := 0; j < n; j++ {
            if arr[i] == j {
                str += "Q"
            } else {
                str += "."
            }
        }
        buf = append(buf, str)
    }
    return
}