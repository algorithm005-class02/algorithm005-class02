import java.util.List;

import static java.util.Arrays.asList;

/**
 * 三角形最小路径和
 * https://leetcode.com/problems/triangle/description/
 */
public class Leetcode_120_triangle {
    /**
     * 方法1："傻"递归
     * (会超时)
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        return helper(0, 0, triangle);
    }

    private int helper(int i, int j, List<List<Integer>> triangle) {
        if (i >= triangle.size() || j >= triangle.get(i).size()) {
            return 0;
        }

        return Math.min(helper(i+1, j, triangle), helper(i + 1, j + 1, triangle))
                + triangle.get(i).get(j);
    }

    /**
     * 方法2：记忆化搜索
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        return helper(0, 0, triangle, new int[m][n]);
    }


    private int helper(int i, int j, List<List<Integer>> triangle, int[][] memo) {
        if (i >= triangle.size() || j >= triangle.get(i).size()) {
            return 0;
        }

        if (memo[i][j] != 0) {
            return memo[i][j];
        }

        return memo[i][j] = Math.min(helper(i+1, j, triangle, memo), helper(i + 1, j + 1, triangle, memo))
                + triangle.get(i).get(j);
    }

    /**
     * 方法3： Bottom Up
     * (直接在原数组上修改）
     */
    public int minimumTotal3(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j,
                        Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))
                                + triangle.get(i).get(j));
            }
        }

        return triangle.get(0).get(0);
    }

    /**
     * 方法3： Bottom Up
     * 定义新的状态数组，不修改原始三角形数组
     */
    public int minimumTotal4(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(triangle.size() - 1).size();
        int[][] dp = new int[m][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (i == n - 1) {
                    dp[i][j] = triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                }
            }
        }
        return dp[0][0];
    }


    /**
     * 方法3：Bottom Up
     * 使用一维数组优化
     */
    public int minimumTotal5(List<List<Integer>> triangle) {
        int n = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }

        return dp[0];
    }


    public static void main(String[] args) {
        Leetcode_120_triangle solution = new Leetcode_120_triangle();
        List<List<Integer>> list = asList(asList(2), asList(3, 4), asList(6, 5, 7), asList(4, 1, 8, 3));
        System.out.println(solution.minimumTotal2(list));
    }

}

