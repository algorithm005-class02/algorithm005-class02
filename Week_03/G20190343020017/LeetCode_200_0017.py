class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0
        width, height, count = len(grid[0]), len(grid), 0
        # 沉岛
        def sink(row, col):
            # terminator
            if grid[row][col] == '0':
                return
            # process
            grid[row][col] = '0'
            # drill down
            if row > 0:
                sink(row-1, col)
            if col > 0:
                sink(row, col - 1)
            if row < height - 1:
                sink(row + 1, col)
            if col < width - 1:
                sink(row, col + 1)

        for r, row in enumerate(grid):
            for c, cell in enumerate(row):
                if cell == '1':
                    sink(r, c)
                    count += 1
        return count