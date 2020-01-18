import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeetCode_64_0341 {
    public static void main(String[] args) {
    }
}

// 1.超出内存限制
class Solution64 {
    private List<Integer> result = new ArrayList<>();
    int rows = 0;
    int cols = 0;
    ;

    public int minPathSum(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        recrusive(grid, 0, 0, 0);
        Collections.sort(result);
        return result.get(0);
    }

    public void recrusive(int[][] grid, int m, int n, int sum) {
        // m, n 为当前元素的坐标
        sum += grid[m][n];
        if (m == rows - 1 && n == cols - 1) {
            result.add(sum);
            return;
        } else {
            if (m == rows - 1) {
                recrusive(grid, m, n + 1, sum);
            } else if (n == cols - 1) {
                recrusive(grid, m + 1, n, sum);
            } else {
                recrusive(grid, m, n + 1, sum);
                recrusive(grid, m + 1, n, sum);
            }
        }
    }
}

//2.暴力 超出时间限制
class Solution64_2 {
    public int calculate(int[][] grid, int i, int j) {
        if (i == grid.length || j == grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        return grid[i][j] + Math.min(calculate(grid, i + 1, j), calculate(grid, i, j + 1));
    }

    public int minPathSum(int[][] grid) {
        return calculate(grid, 0, 0);
    }
}

//3. 动态规划
class Solution64_3 {
    public int minPathSum(int[][] grid) {
        //初始化第一行
        for (int i = 1; i < grid[0].length; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }

        //初始化第一列
        for (int i = 1; i < grid.length; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }

        int rows = grid.length;
        int cols = grid[0].length;
        for (int m = 1; m < rows; m++) {
            for (int n = 1; n < cols; n++) {
                grid[m][n] = Math.min(grid[m - 1][n], grid[m][n - 1]) + grid[m][n];
            }
        }
        return grid[rows - 1][cols - 1];
    }
}

