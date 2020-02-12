import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=36 lang=java
 * * [36] 有效的数独
 */
// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();  
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> squareMap = new HashMap<>(); 
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if (board[i][j] == '.') continue;
                // check row
                if (rowMap.get(i) == null) rowMap.put(i, new HashSet<>());
                Set<Character> row = rowMap.get(i);
                if (row.contains(board[i][j])) {
                    return false;
                } else {
                    row.add(board[i][j]);
                }

                // check col
                if (colMap.get(j) == null) colMap.put(j, new HashSet<>());
                Set<Character> col = colMap.get(j);
                if (col.contains(board[i][j])) {
                    return false;
                } else {
                    col.add(board[i][j]);
                }

                //check square
                if (squareMap.get((i / 3) * 3 + j / 3)  == null) squareMap.put((i / 3) * 3 + j / 3, new HashSet<>());
                Set<Character> square = squareMap.get((i / 3) * 3 + j / 3);
                if (square.contains(board[i][j])) {
                    return false;
                } else {
                    square.add(board[i][j]);
                }
            }
        }
        return true;
    }
}
// @lc code=end

