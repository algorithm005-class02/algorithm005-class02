class Solution:
    def updateBoard(self, board: List[List[str]], click: List[int]) -> List[List[str]]:
        if not board:
            return []
        width, height = len(board[0]), len(board)
        # 翻开方块
        def helper(row, col):
            # 挖到地雷
            if board[row][col] == 'M':
                board[row][col] = 'X'
                return

            # 遍历四周计算地雷数量
            count = 0
            for r in range(row - 1 if row > 0 else row, row + 2 if row < height - 1 else row + 1):
                for c in range(col - 1 if col > 0 else col, col + 2 if col < width - 1 else col + 1):
                    if board[r][c] == 'M':
                        count += 1
            if count:
                board[row][col] = str(count)
            else:
                board[row][col] = 'B'
                # 打开周围网格
                for r in range(row - 1 if row > 0 else row, row + 2 if row < height - 1 else row + 1):
                    for c in range(col - 1 if col > 0 else col, col + 2 if col < width - 1 else col + 1):
                        if board[r][c] == 'E':
                            helper(r, c)
        helper(click[0], click[1])
        return board