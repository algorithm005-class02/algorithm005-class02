package leetcode.week03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode_51_0069 {
    public List<List<String>> solveNQueens (int n) {
        char[][] borad = new char[n][n];
        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = 0; i < n; i++) {
            for (int j = 0 ; j < n; j++) {
                borad[i][j] = '.';
            }
            dfs(borad, 0 , res);
        }
        return res;
    }

    /**
     * 深度优先
     * @param borad
     * @param colIndex
     * @param res
     */
    private void dfs(char[][] borad, int colIndex, List<List<String>> res) {
        if (colIndex == borad.length) {
            res.add(construct(borad));
            return;
        }
        for (int i = 0; i < borad.length; i++) {
            if (validate(borad , i , colIndex)) {
                borad[i][colIndex] = 'Q';
                dfs(borad , colIndex+1 , res);
                borad[i][colIndex] = '.';
            }
        }
    }


    private List<String> construct(char[][] borad) {
        List<String> res = new LinkedList<String>();
        for (int i = 0 ; i < borad.length ; i++) {
            String s = new String(borad[i]);
            res.add(s);
        }
        return res;
    }

    private boolean validate(char[][] borad, int x, int y) {
        for (int i = 0 ; i < borad.length ; i++) {
            for (int j = 0; j < y ; j++) {
                if(borad[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }
        return true;
    }

    public static void main (String args[]) {
        LeetCode_51_0069 nQueens = new LeetCode_51_0069();
        List<List<String>> res = nQueens.solveNQueens(4);
        for (List<String> resList : res) {
            for (String s : resList) {
                System.out.println(s);
            }
        }
    }
}
