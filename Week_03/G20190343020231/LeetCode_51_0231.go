package main

import (
	"fmt"
)

// 使用DFS遍历二维数组，并打印遍历的路径
func main() {
	//fmt.Println(solveNQueens(4))
	//fmt.Println(solveNQueens(4))
	//fmt.Println(solveNQueens(1))
	//fmt.Println(solveNQueens(2))
	//fmt.Println(solveNQueens(3))
	//fmt.Println(solveNQueens(5))

	fmt.Println(solveNQueens_2(1))
	fmt.Println(solveNQueens_2(2))
	fmt.Println(solveNQueens_2(3))
	fmt.Println(solveNQueens_2(4))
	fmt.Println(solveNQueens_2(5))
}

func solveNQueens(n int) [][]string {
	if n == 1 {
		return [][]string{[]string{"Q"}}
	}
	if n <= 3 {
		return [][]string{}
	}
	// res: [[1, 0, 2], [0, 0, 0]]，表示第零行的第一个位置是遍历结果
	// 列，撇，捺的剪枝
	lie, pie, na := make(map[int]bool), make(map[int]bool), make(map[int]bool)
	// 嵌套函数
	dfs := func(n int, rows []int, res *[][]int) {}
	dfs = func(n int, rows []int, res *[][]int) {
		row := len(rows)
		// terminator
		if n == row {
			tempR := make([]int, len(rows))
			// 必须要copy一份，否则结果不正确
			copy(tempR, rows)
			*res = append(*res, tempR)
			return
		}
		for col := 0; col < n; col++ {
			// 剪枝
			if !lie[col] && !pie[row+col] && !na[row-col] {
				// 不被攻击
				// 设置攻击状态
				lie[col], pie[row+col], na[row-col] = true, true, true
				// drill down
				dfs(n, append(rows, col), res)
				// 清除状态
				lie[col], pie[row+col], na[row-col] = false, false, false
			}
		}
	}

	res := [][]int{}
	dfs(n, []int{}, &res)
	//fmt.Println(res)
	resString := formatRes(&res)
	return resString
}

//func DFS(n int, rows []int, res *[][]int) {
//	// terminator
//	if n == len(rows) {
//		tempR := make([]int, len(rows))
//		// 必须要copy一份，否则结果不正确
//		copy(tempR, rows)
//		*res = append(*res, tempR)
//		return
//	}
//	for col := 0; col < n; col++ {
//		// 剪枝
//		// drill down
//		DFS(n, append(rows, col), res)
//	}
//}

func formatRes(res *[][]int) [][]string {
	resStr := [][]string{}
	for i := 0; i < len(*res); i++ {
		tempArray := []string{}
		for j := 0; j < len((*res)[i]); j++ {
			temp := targetStr(len((*res)[i]), (*res)[i][j])
			tempArray = append(tempArray, temp)
		}
		resStr = append(resStr, tempArray)
	}
	return resStr
}

func targetStr(n, target int) string {
	str := ""
	for i := 0; i < n; i++ {
		if i == target {
			str += "Q"
			continue
		}
		str += "."
	}
	return str
}

// 优化。使用字节数组来表示string
func solveNQueens_2(n int) [][]string {
	res := [][]string{}
	col, pie, na := make(map[int]bool), make(map[int]bool), make(map[int]bool)
	helper(0, n, []string{}, col, pie, na, &res)
	return res
}

func helper(r, n int, strArray []string, col, pie, na map[int]bool, res *[][]string) {
	// terminator
	if r == n {
		temp := make([]string, n)
		// 还是需要拷贝
		copy(temp, strArray)
		*res = append(*res, temp)
	}
	for j := 0; j < n; j++ {
		if !col[j] && !pie[r+j] && !na[r-j] {
			tempArray := make([]byte, n)
			for k := 0; k < n; k++ {
				tempArray[k] = '.'
			}
			tempArray[j] = 'Q'
			col[j], pie[r+j], na[r-j] = true, true, true
			helper(r+1, n, append(strArray, string(tempArray)), col, pie, na, res)
			col[j], pie[r+j], na[r-j] = false, false, false
		}
	}
}
