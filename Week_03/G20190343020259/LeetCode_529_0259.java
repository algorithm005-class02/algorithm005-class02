class Solution {
    private int[] dx = {-1, 0, 1, -1, 1, 0, 1, -1};
    private int[] dy = {-1, 1, 1, 0, -1, -1, 0, 1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y =  click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        dfs(board, x, y);

        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E') {
            return;
        }

        int num = calNumsOfMine(board, x, y);

        if (num == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                dfs(board, x+dx[i], y+dy[i]);
            }
        } else {
            board[x][y] = (char)('0' + num);
        }
    }

    private int calNumsOfMine(char[][] board, int x, int y) {
        int num = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length) {
                continue;
            }
            if (board[nx][ny] == 'M' || board[nx][ny] == 'X') {
                num++;
            }
        }

        return num;
    }
}