class Solution {
    private static char[][] g;
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        g = grid;
        int numOfIslands = 0;
        int rLength = g.length;
        int cLength = g[0].length;

        for (int i = 0; i < rLength; i++) {
            for (int j = 0; j < cLength; j++) {
                if (g[i][j] == '1') {

                    numOfIslands++;
                    g[i][j] = '0';
                    floodFill(i, j);
                }
            }
        }

        return numOfIslands;
    }

    //dfs
    public static void floodFill(int i, int j) {
        //search land '1' set as '0'
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int adjI = i + dx[k];
            int adjJ = j + dy[k]; // get new location

            if (adjI >= 0 && adjI < g.length && adjJ >= 0 && adjJ < g[0].length) {
                if (g[adjI][adjJ] == '1') {
                    g[adjI][adjJ] = '0';
                    floodFill(adjI, adjJ);
                }
            }
        }

    }
}