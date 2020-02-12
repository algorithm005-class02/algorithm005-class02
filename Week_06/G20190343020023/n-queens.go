func solveNQueens(n int) [][]string {
	var res [][]string
	var queens [][]byte
	cols := make(map[int]int)
	pie := make(map[int]int)
	na := make(map[int]int)
	for i := 0; i < n; i++ {
		queens = append(queens, []byte{})
		for j := 0; j < n; j++ {
			queens[i] = append(queens[i], '.')
		}
	}
	helper(n, &res, &cols, &pie, &na, 0, &queens)
	return res
}

func helper(n int, res *[][]string, cols, pie, na *map[int]int, row int, queens *[][]byte) {
	if n == row {
		var result []string
		for _, row := range *queens {
			result = append(result, string(row))
		}
		(*res) = append(*res, result)
		return
	}

	for col := 0; col < n; col++ {
		if (*cols)[col] != 1 && (*pie)[row+col] != 1 && (*na)[row-col] != 1 {
			(*cols)[col], (*pie)[row+col], (*na)[row-col] = 1, 1, 1
			(*queens)[row][col] = 'Q'
			helper(n, res, cols, pie, na, row+1, queens)
			(*cols)[col], (*pie)[row+col], (*na)[row-col] = 0, 0, 0
			(*queens)[row][col] = '.'
		}
	}
}