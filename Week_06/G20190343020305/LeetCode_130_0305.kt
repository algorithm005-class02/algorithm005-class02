//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。 
//
// 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。 
//
// 示例: 
//
// X X X X
//X O O X
//X X O X
//X O X X
// 
//
// 运行你的函数后，矩阵变为： 
//
// X X X X
//X X X X
//X X X X
//X O X X
// 
//
// 解释: 
//
// 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
//填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun solve(board: Array<CharArray>): Unit {
        if (board.isEmpty()) return
        val row = board.size
        val col = board[0].size
        for (i in 0 until row) {
            check(board, i, 0, row, col)
            if (col > 1) check(board, i, col - 1, row, col)
        }
        for (j in 1 until col - 1) {
            check(board, 0, j, row, col)
            if (row > 1) check(board, row - 1, j, row, col)
        }
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (board[i][j] == 'O') board[i][j] = 'X'
            }
        }
        for (i in 0 until row) {
            for (j in 0 until col) {
                if (board[i][j] == '1') board[i][j] = 'O'
            }
        }
    }

    private fun check(board: Array<CharArray>, i: Int, j: Int, row: Int, col: Int) {
        if (board[i][j] == 'O') {
            board[i][j] = '1'
            if (i > 1) check(board, i - 1, j, row, col)
            if (j > 1) check(board, i, j - 1, row, col)
            if (i + 1 < row) check(board, i + 1, j, row, col)
            if (j + 1 < col) check(board, i, j + 1, row, col)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
