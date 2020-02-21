package main

var offsets [][2]int

func init() {
	offsets = [][2]int{
		[2]int{-1, -1},
		[2]int{0, -1},
		[2]int{1, -1},
		[2]int{1, 0},
		[2]int{1, 1},
		[2]int{0, 1},
		[2]int{-1, 1},
		[2]int{-1, 0}}
}

func updateBoard(board [][]byte, click []int) [][]byte {
	m, n := len(board), len(board[0])
	row, col := click[0], click[1]

	if board[row][col] == 'M' {
		board[row][col] = 'X'
	} else {
		count := 0
		for _, o := range offsets {
			r, c := row+o[0], col+o[1]
			if 0 <= r && r < m && 0 <= c && c < n && board[r][c] == 'M' {
				count++
			}
		}

		if count > 0 {
			board[row][col] = byte(count + int('0'))
		} else {
			board[row][col] = 'B'
			for _, o := range offsets {
				r, c := row+o[0], col+o[1]
				if 0 <= r && r < m && 0 <= c && c < n && board[r][c] == 'E' {
					updateBoard(board, []int{r, c})
				}
			}
		}
	}

	return board
}
