/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N皇后
 *
 * https://leetcode-cn.com/problems/n-queens/description/
 *
 * algorithms
 * Hard (66.92%)
 * Likes:    291
 * Dislikes: 0
 * Total Accepted:    21.5K
 * Total Submissions: 32.1K
 * Testcase Example:  '4'
 *
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 
 * 
 * 
 * 上图为 8 皇后问题的一种解法。
 * 
 * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4
 * 输出: [
 * ⁠[".Q..",  // 解法 1
 * ⁠ "...Q",
 * ⁠ "Q...",
 * ⁠ "..Q."],
 * 
 * ⁠["..Q.",  // 解法 2
 * ⁠ "Q...",
 * ⁠ "...Q",
 * ⁠ ".Q.."]
 * ]
 * 解释: 4 皇后问题存在两个不同的解法。
 * 
 * 
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> pie = new HashSet<>();
    HashSet<Integer> na = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        if(n < 1) return new ArrayList<>();
        Stack<Integer> cur_state = new Stack<>();
        dfs(n,0, cur_state);
        //return generate_state(n,result);
        return null;
        //System.out.print(result.toString());

    }

    private void dfs(int n, int row, Stack<Integer> cur_state) {
        //teminator
        if(row >=n){
            result.add(cur_state);
            System.out.println(cur_state);
            return;
        }
        for(int col = 0;col < n;col++){
            if(cols.contains(col) || pie.contains(row + col) || na.contains(row - col)) {
                continue;
            }
            //update the flags
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            cur_state.add(col);

            dfs(n,row + 1,cur_state);
            //reverse status
            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            cur_state.pop();
        }
    }

//    private List<List<String>> generate_state(int n,List<List<Integer>> result) {
//        List<String> board = new ArrayList<>();
//        for(List<Integer> res:result){
//            for(int i :res){
//                //board.add("."  * i
//            }
//        }
////        for(int i = 0;i < result.size();i++){
////            System.out.println(result.get(i));
////        }
//        return null;
//    }

    public static void main(String[] args) {
        Solution nq = new Solution();
        System.out.println(nq.solveNQueens(11));
    }
}
// @lc code=end

