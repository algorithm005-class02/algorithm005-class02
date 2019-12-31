class Solution:
    def solveNQueens(self, n):
        queen_board = []
        def generate_queens(col, pie ,na):
            current_row = len(col)
            if current_row == n:
                queen_board.append(col)
                return
            for x in range(n):
                if x not in col and current_row + x not in pie and current_row - x not in na:
                    generate_queens(col + [x], pie + [current_row + x], na + [current_row - x])
        generate_queens([], [], [])
        return [["." * x + "Q" + "." * (n - 1 - x) for x in solution] for solution in queen_board]

if __name__ == '__main__':
    test = Solution()
    print(test.solveNQueens(4))