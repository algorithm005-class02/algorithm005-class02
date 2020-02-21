class Solution {
public List<List<String>> solveNQueens(int n) {
        List<List<String>> output = new ArrayList<>();
        char[][] broad = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                broad[i][j] = '.';
            }
        }
        dfs(broad, 0, output);
        return output;
    }

    void dfs(char[][] broad, int y, List<List<String>> output) {
        if (broad.length == y) {
            //add output
            output.add(constructBroad(broad));
            return;
        }

        for (int x=0; x<broad.length; x++) {
            if (isValid(broad, x, y)) {
                broad[x][y] = 'Q';
                dfs(broad, y+1, output);
                broad[x][y] = '.';
            }
        }
    }

    public boolean isValid(char[][] broad, int x, int y) {
        for (int i=0; i<broad.length; i++) {
            for (int j=0; j<y; j++) {
                if (broad[i][j]=='Q' && (x==i || x+j==i+y || i+j==x+y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<String> constructBroad(char[][] broad) {
        List<String> str = new ArrayList<>();
        for (int i=0; i<broad.length; i++) {
            str.add(new String(broad[i]));
        }
        return str;
    }
}
