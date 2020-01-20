class Solution {
    private static final int MAX = 9;

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != MAX || board[0].length != MAX) {
            return false;
        }

        HashMap<Integer, Integer>[] rows = new HashMap[MAX];
        HashMap<Integer, Integer>[] columns = new HashMap[MAX];
        HashMap<Integer, Integer>[] boxes = new HashMap[MAX];

        for (int i = 0; i < MAX; i++) {
            rows[i] = new HashMap<>(MAX);
            columns[i] = new HashMap<>(MAX);
            boxes[i] = new HashMap<>(MAX);
        }

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int num = (int)board[i][j];
                int boxIdx = i / 3 * 3 + j / 3;
                rows[i].put(num, rows[i].getOrDefault(num, 0) + 1);
                columns[j].put(num, columns[j].getOrDefault(num, 0) + 1);
                boxes[boxIdx].put(num, boxes[boxIdx].getOrDefault(num, 0) + 1);

                if (rows[i].get(num) > 1 || columns[j].get(num) > 1 || boxes[boxIdx].get(num) > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}