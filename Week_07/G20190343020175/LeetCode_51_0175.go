package main

func solveNQueens(n int) [][]string {
	result := [][]int{}
	dfs(0, n, []int{}, []int{}, []int{}, &result)
	return formatResult(result)
}

func dfs(row, queenCount int, queens, dalas, hills []int, result *[][]int) {
	if row >= queenCount {
		solution := make([]int, len(queens))
		copy(solution, queens)
		*result = append(*result, solution)
		return
	}

	for col := 0; col < queenCount; col++ {
		if attack(col, queens) || attack(row-col, dalas) || attack(row+col, hills) {
			continue
		}

		queens = append(queens, col)
		dalas = append(dalas, row-col)
		hills = append(hills, row+col)

		dfs(row+1, queenCount, queens, dalas, hills, result)

		queens = queens[:len(queens)-1]
		dalas = dalas[:len(dalas)-1]
		hills = hills[:len(hills)-1]
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

func attack(n int, nums []int) bool {
	for _, v := range nums {
		if n == v {
			return true
		}
	}
	return false
}
