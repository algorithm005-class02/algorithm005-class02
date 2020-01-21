package week06

func numIslands(grid [][]byte) int {

	result := 0
	for i := 0; i < len(grid); i++ {

		for j := 0; j < len(grid[i]); j++ {

			if grid[i][j] == '1' {
				dfs(grid, i, j)
				result++
			}
		}
	}
	return result
}

var fx = [4]int{1, 0, -1, 0}
var fy = [4]int{0, -1, 0, 1}

func dfs(grid [][]byte, x int, y int) {

	if x < 0 || x >= len(grid) || y < 0 || y >= len(grid[0]) || grid[x][y] == '0' {
		return
	}

	grid[x][y] = '0'
	for i := 0; i < 4; i++ {
		dfs(grid, x+fx[i], y+fy[i])
	}
}
