package main

func solveNQueens(n int) [][]string {
	result := [][]int{}
	dfs(0, n, []int{}, []int{}, []int{}, &result)
	return formatResult(result)
}

func dfs(row, n int, queens, dales, hills []int, result *[][]int) {
	if row == n {
		q := make([]int, len(queens))
		copy(q, queens)
		*result = append(*result, q)
		return
	}

	for col := 0; col < n; col++ {
		if in(col, queens) || in(row+col, hills) || in(row-col, dales) {
			continue
		}

		dales = append(dales, row-col)
		hills = append(hills, row+col)
		queens = append(queens, col)

		dfs(row+1, n, queens, dales, hills, result)

		// delete the error queen state
		dales = dales[:len(dales)-1]
		hills = hills[:len(hills)-1]
		queens = queens[:len(queens)-1]
	}
}

func formatResult(result [][]int) [][]string {
	chessboards := [][]string{}
	for _, queens := range result {
		chessboards = append(chessboards, formatChessboard(queens))
	}

	return chessboards
}

func formatChessboard(queens []int) []string {
	chessboard := []string{}
	for _, queen := range queens {
		row := ""
		for i := 0; i < len(queens); i++ {
			if i == queen {
				row += "Q"
			} else {
				row += "."
			}
		}
		chessboard = append(chessboard, row)
	}

	return chessboard
}

func in(n int, nums []int) bool {
	for _, v := range nums {
		if n == v {
			return true
		}
	}
	return false
}
