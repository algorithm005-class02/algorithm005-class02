package main

import (
	"fmt"
)

func isValidSudoku1(board [][]byte) bool {
	rowCnt := [9]int{}
	colCnt := [9]int{}
	boxCnt := [9]int{}

	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if '.' == board[i][j] {
				continue
			}
			num := board[i][j] - 48
			// 处理行
			if (rowCnt[i]>>num)%2 == 1 {
				return false
			} else {
				rowCnt[i] += 1 << num
			}

			// 处理列
			if (colCnt[j]>>num)%2 == 1 {
				return false
			} else {
				colCnt[j] += 1 << num
			}

			// 处理框
			boxNum := i/3*3 + j/3
			if (boxCnt[boxNum]>>num)%2 == 1 {
				return false
			} else {
				boxCnt[boxNum] += 1 << num
			}
		}
	}

	return true
}

func isValidSudoku(board [][]byte) bool {
	var row [9][10]bool
	var cow [9][10]bool
	var block [9][10]bool
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			var index = i/3*3 + j/3
			if board[i][j] != '.' {
				var tmp = board[i][j] - '0'
				if row[i][tmp] {
					return false
				} else {
					row[i][tmp] = true
				}
				if cow[j][tmp] {
					return false
				} else {
					cow[j][tmp] = true
				}
				if block[index][tmp] {
					return false
				} else {
					block[index][tmp] = true
				}

			}
		}

	}
	return true
}

func main() {
	board := [][]byte{
		[]byte(".87654321"),
		[]byte("2....4..."),
		[]byte("3........"),
		[]byte("4........"),
		[]byte("5........"),
		[]byte("6........"),
		[]byte("7........"),
		[]byte("8........"),
		[]byte("9........"),
	}

	fmt.Println(isValidSudoku(board))
}
