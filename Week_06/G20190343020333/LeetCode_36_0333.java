class Solution {
    public boolean isValidSudoku(char[][] board) {
        int length = board[0].length;
        int width = board.length;

        HashMap<Integer, Integer>[] X = new HashMap[9];
        HashMap<Integer, Integer>[] Y = new HashMap[9];
        HashMap<Integer, Integer>[] XY = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            X[i] = new HashMap<Integer, Integer>();
            Y[i] = new HashMap<Integer, Integer>();
            XY[i] = new HashMap<Integer, Integer>();
        }
        for(int i = 0; i < length ; i++){
            for(int j = 0; j < width ; j++){
                HashMap<Integer, Integer> tempX = X[i];
                //获取Y轴LinkedList
                HashMap<Integer, Integer> tempY = Y[j];
                
                //获取XY轴LinkedList
                HashMap<Integer, Integer> tempXY = XY[(i/3)*3 + j/3];

                if(board[i][j] != '.'){ 
                    if(
                    tempX.get((int)board[i][j]) == null && 
                    tempY.get((int)board[i][j]) == null&&
                    tempXY.get((int)board[i][j]) == null 
                    ){
                        tempX.put((int)board[i][j],1);
                        tempY.put((int)board[i][j],1);
                        tempXY.put((int)board[i][j],1); 
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}