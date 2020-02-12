#
# @lc app=leetcode.cn id=51 lang=python3
#
# [51] N皇后
#

# @lc code=start
class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        results = []

        col = 0
        r_aix = 0
        l_aix = 0

        def dfs(cols, cur_line, col, r_aix, l_aix):
            cur_cols = cols.copy()
            if cur_line == n:
                cur_result = [["." for _ in range(n)] for _ in range(n)]
                print(cur_cols)
                for i in range(n):
                    cur_result[i][n - 1 - cols[i]] = 'Q'
                results.append(["".join(line) for line in cur_result])
                return
            
            valid = (col | r_aix | l_aix) ^ ((0b1 << n) - 1)

            cur_col = 0
            while(valid):
                if (valid & 0b1):
                    cur_cols.append(cur_col)
                    dfs(cur_cols ,cur_line+1, col|(0b1 << cur_col), (r_aix|(0b1 << cur_col)) >> 1, ((l_aix|(0b1 << cur_col)) << 1) & ((0b1 << n) - 1) )
                    cur_cols.pop()
                valid = valid >> 1
                cur_col += 1
        
        dfs([], 0, col, r_aix, l_aix)

        return results

        
# @lc code=end

