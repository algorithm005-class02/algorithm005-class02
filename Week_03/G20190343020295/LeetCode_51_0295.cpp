class Solution {
public:
   vector<vector<string>> solveNQueens(int n) {
        vector<vector<string>> myRes;
        vector<string> nQueens(n, string(n, '.'));
        saveQueen(0, n, nQueens, myRes);
        return myRes;
    }
private:
     void saveQueen(int rowIndex, int n, vector<string> nQueen,
                   vector<vector<string>>& board) {
        // terminator
        if (rowIndex == n) {
            board.push_back(nQueen);
            return;
        }
        // current process and drill down
        for (int colIndex = 0; colIndex < n; colIndex++) {
            if (!kiilQueen(rowIndex, colIndex, n, nQueen)) {
                nQueen[rowIndex][colIndex] = 'Q';
                saveQueen(rowIndex + 1, n, nQueen, board);
                nQueen[rowIndex][colIndex] = '.';
            }
        }
        // reverse
        return;
    }
    bool kiilQueen(int rowIndex, int colIndex, int n, vector<string>& nQueen) {
        int checkLinePos = 0;
        for (int i = 0; i < n; i++) {
            if (i == rowIndex) continue;
            // 检查该列是否会杀死皇后
            if (nQueen[i][colIndex] == 'Q') return true;
            // 检查对角线是否会杀死皇后
            checkLinePos = rowIndex + colIndex - i;
            if (checkLinePos >=0 && checkLinePos < n) {
                if (nQueen[i][checkLinePos] == 'Q') return true;
            }
            checkLinePos = i - (rowIndex - colIndex);
            if (checkLinePos >=0 && checkLinePos < n) {
                if (nQueen[i][checkLinePos] == 'Q') return true;
            }
        }
        return false;
    }
};