package G20190343020231

func solveNQueens(n int) [][]string {
	if n == 1 {
		return [][]string{[]string{"Q"}}
	}
	if n <= 3 {
		return [][]string{}
	}

	// res: [[1, 0, 2], [0, 0, 0]]，表示第零行的第一个位置是遍历结果
	// 列，撇，捺的剪枝
	lie := make(map[int]bool)
	pie := make(map[int]bool)
	na := make(map[int]bool)

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
				lie[col] = true
				pie[row+col] = true
				na[row-col] = true
				// drill down
				dfs(n, append(rows, col), res)
				// 清除状态
				lie[col] = false
				pie[row+col] = false
				na[row-col] = false
			}
		}
	}

	res := [][]int{}
	dfs(n, []int{}, &res)
	//fmt.Println(res)
	resString := formatRes(&res)
	return resString
}


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