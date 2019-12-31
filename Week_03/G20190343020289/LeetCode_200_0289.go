package G20190343020289

//200. 岛屿数量
var dx = [4]int{-1, 1, 0, 0}
var dy = [4]int{0, 0, 1, -1}
var row, col int

func numIslands(grid [][]byte) int {
	row = len(grid)
	if row == 0 {
		return 0
	}
	col = len(grid[0])
	count := 0
	for i := 0; i < row; i++ {
		for j := 0; j < col; j++ {
			if grid[i][j] == '1' {
				//DFS(grid, i, j)
				BFS(grid, i, j)
				count++
			}
		}
	}
	return count
}

//func DFS(grid [][]byte, i int, j int) {
//	//边界：i j 超出,或当前值部位“1”
//	if i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1' {
//		return
//	}
//	grid[i][j] = '0'
//	// 以当前点为坐标轴原点，遍历四个方向
//	for k := 0; k < 4; k++ {
//		DFS(grid, i+dx[k], j+dy[k])
//	}
//}

func BFS(grid [][]byte, i, j int) {
	queue := make([]int, 0)
	queue = append(queue, i, j)
	grid[i][j] = 0
	for len(queue) > 0 {
		i, j := queue[0], queue[1]
		queue = queue[2:]
		for k := 0; k < 4; k++ {
			tmp_i := i + dx[k]
			tmp_j := j + dy[k]

			if 0 <= tmp_i && tmp_i < row && 0 <= tmp_j && tmp_j < col && grid[tmp_i][tmp_j] == '1' {
				grid[tmp_i][tmp_j] = '0'
				queue = append(queue, tmp_i, tmp_j)
			}
		}
	}
}
