import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;


//递归 + 回溯
/* 
class Solution {
    HashSet cols = new HashSet<>();
    HashSet pie = new HashSet<>();
    HashSet na = new HashSet<>();
    int count = 0;
    List<List<String>> res = new ArrayList<>();
    public int totalNQueens(int n) {
        if(n < 1)  return count;
        help(n,0);
        return count;
    }

    private void help(int n, int row) {
        if(row >= n){
            //List<String> board = generate(n,cur_state);
            count ++;
            return;
        }

        for(int col = 0; col < n; ++ col){
            if(cols.contains(col)||pie.contains(row + col)||na.contains(row-col)){
                continue;
            }
            cols.add(col);
            pie.add(row + col);
            na.add(row - col);
            //cur_state.add(col);

            help(n,row + 1);

            cols.remove(col);
            pie.remove(row + col);
            na.remove(row - col);
            //cur_state.pop();
        }

    }
}
*/

//位运算 + 递归 + 回溯
class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n < 1)  return 0;
        dfs(n,0,0,0,0);
        return count;
        
    }

    private void dfs(int n, int row, int cols, int pie, int na) {
        if(row >= n){
            count ++;
            return;
        }
        //得到所有空位
        int bits = (~ (cols | pie | na)) & ((1 << n) - 1);

        //循环得到所有N皇后方案
        while(bits != 0){
            //取得最低位的1
            int p = bits & - bits;
            //将最后一位的1置为0，即皇后放置的位置
            bits = bits & (bits - 1);
            dfs(n, row + 1, cols | p, (pie | p) << 1, (na | p) >> 1);
        }
    }
}
