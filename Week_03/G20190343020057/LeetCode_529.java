class Solution {
    int[][] surround = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
    public char[][] updateBoard(char[][] board, int[] click) {
        int X = click[0];
        int Y = click[1];
        if(click.length!=2||X>board.length||Y>board[0].length) return null;//检查输入
        if(board[X][Y]=='M') {
            board[X][Y] = 'X';//不巧挖到地雷,不能放在DFS中，与第一句判断条件冲突
        }else{
            DFS(board,X,Y);
        }
        return board;
    }
    private void DFS(char[][] board, int X, int Y){
        if(X<0||X>=board.length||Y<0||Y>=board[0].length||board[X][Y]!='E') return;
        /*将判断条件提到这个函数开头，避免在后面扩展时进行判断，统一在函数开头判断。
        判断条件注意>=,等号不能少
        这里必须增加非’E‘停止迭代，不然会死循环。
        */
        int numM = findMine(board,X,Y);//计算周边的地雷个数
        if(numM != 0){//地雷非0情况下进行标记
            board[X][Y] = (char)('0'+numM);
        }
        else{
            board[X][Y] = 'B';//先更改该点标记，然后再递推周边的点
            for(int[] sub:surround){
                DFS(board,X+sub[0],Y+sub[1]);
            }
        }
        return;

    }
    private int findMine(char[][]board, int X,int Y){
        int count=0;
        for(int[] sub:surround){
            int newX = X + sub[0];
            int newY = Y + sub[1];
            if(newX>=0 && newX<board.length && newY>=0 && newY < board[0].length &&board[newX][newY]=='M') //这里可以设置成正向的条件
                count++;
        }
        return count;
    }
}