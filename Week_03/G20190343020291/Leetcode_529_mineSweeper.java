import java.util.Arrays;
import java.util.LinkedList;

/**
 * 扫雷游戏
 * https://leetcode.com/problems/minesweeper/
 */
public class Leetcode_529_mineSweeper {
    /**
     * DFS
     * 思路同岛屿的数量题目，区别是本题填充逻辑略复杂
     */

    // 八个方向
    private int[][] cord = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) {
            return board;
        }

        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        dfs(board, row, col);
        return board;
    }


    private void dfs(char[][] board, int row, int col) {
        if (!validIndex(board, row, col) || board[row][col] != 'E') {
            return;
        }
        int mines = getMines(board, row, col);
        if (mines > 0) {
            board[row][col] = (char) ('0' + mines);
        } else {
            board[row][col] = 'B';
            for (int[] cur : cord) {
                dfs(board, row + cur[0], col + cur[1]);
            }
        }
    }


    private boolean validIndex(char[][] board, int row, int col) {
        return !(row < 0 || col < 0 || row >= board.length || col >= board[0].length);
    }


    private int getMines(char[][] board, int row, int col) {
        int mines = 0;

        for (int[] cur : cord) {
            int newRow = row + cur[0];
            int newCol = col + cur[1];

            if (validIndex(board, newRow, newCol)
                    && (board[newRow][newCol] == 'M' || board[newRow][newCol] == 'X')) {
                mines++;
            }
        }

        return mines;
    }


    /**
     * BFS
     */

    public char[][] updateBoard2(char[][] board, int[] click) {
        if (board == null || board.length == 0) {
            return board;
        }

        int row = click[0];
        int col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
            return board;
        }

        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(click);

        while (!queue.isEmpty()) {
            int[] tmp = queue.poll();
            row = tmp[0];
            col = tmp[1];
            if (!validIndex(board, row, col) || board[row][col] != 'E') {
                continue;
            }

            int mines = getMines(board, row, col);
            if (mines > 0) {
                board[row][col] = (char) ('0' + mines);
            } else {
                board[row][col] = 'B';
                for (int[] cur : cord) {
                    int newRow = row + cur[0];
                    int newCol = col + cur[1];
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return board;
    }


    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};

        Leetcode_529_mineSweeper solution = new Leetcode_529_mineSweeper();
        System.out.println(Arrays.deepToString(solution.updateBoard2(board, click)));
    }
}
