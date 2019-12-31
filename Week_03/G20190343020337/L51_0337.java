package algorithm.leetcode.回溯;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L51_eight_queen {

    //缓存
    Set<String> occupied_columns = new HashSet<>();
    Set<String> occupied_rows    = new HashSet<>();
    Set<String> occupied_slash   = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        return null;
    }

    public void placequeen(int level,int max,String answer)
    {
        if(level==max){
            System.out.println(answer);
            return;
        }
        for(int i=0;i<max;i++){
            if(canPlace(level+1,i,max)){
                placequeen(level+1,max,answer+","+i);
                revertCache(level+1,i,max);
            }
        }
    }

    private void revertCache(int placelevel, int column, int max) {
        occupied_rows.remove(String.valueOf(placelevel-1));
        occupied_columns.remove(String.valueOf(column));
        int slash_x=placelevel-1;
        int slash_y = column;
        for(int x=slash_x,y=slash_y;x<max&&y<max;x++,y++){
            occupied_columns.remove(x + "," + y);
        }
        for(int x=slash_x,y=slash_y;x>=0&&y>=0;x--,y--){
            occupied_columns.remove(x + "," + y);
        }
        for(int x=slash_x,y=slash_y;x<max&&y>=0;x++,y--){
            occupied_columns.remove(x + "," + y);
        }
        for(int x=slash_x,y=slash_y;x>=0&&y<max;x--,y++){
            occupied_columns.remove(x + "," + y);
        }
    }




    public boolean canPlace(int placelevel,int column,int max){

        boolean canplace = true;
        int slash_x=placelevel-1;
        int slash_y = column;
        if(occupied_rows.contains(String.valueOf(placelevel) )||occupied_columns.contains( String.valueOf(column) ))
            canplace=false;
        for(int x=slash_x,y=slash_y;x<max&&y<max;x++,y++){
            if(occupied_slash.contains(x + "," + y)){
                canplace=false;
            }
        }
        for(int x=slash_x,y=slash_y;x>=0&&y>=0;x--,y--){
            if(occupied_slash.contains(x + "," + y)){
                canplace=false;
            }
        }
        for(int x=slash_x,y=slash_y;x<max&&y>=0;x++,y--){
            if(occupied_slash.contains(x + "," + y)){
                canplace=false;
            }
        }
        for(int x=slash_x,y=slash_y;x>=0&&y<max;x--,y++){
            if(occupied_slash.contains(x + "," + y)){
                canplace=false;
            }
        }
        if(canplace){
            occupied_rows.add(String.valueOf(placelevel));
            occupied_columns.add(String.valueOf(column));
            for(int x=slash_x,y=slash_y;x<max&&y<max;x++,y++){
                occupied_columns.add(x + "," + y);
            }
            for(int x=slash_x,y=slash_y;x>=0&&y>=0;x--,y--){
                occupied_columns.add(x + "," + y);
            }
            for(int x=slash_x,y=slash_y;x<max&&y>=0;x++,y--){
                occupied_columns.add(x + "," + y);
            }
            for(int x=slash_x,y=slash_y;x>=0&&y<max;x--,y++){
                occupied_columns.add(x + "," + y);
            }
        }
        return canplace;



    }

    public static void main(String args[]){
        L51_eight_queen eight_queen = new L51_eight_queen();
        eight_queen.placequeen(0,8,"");



    }

}
