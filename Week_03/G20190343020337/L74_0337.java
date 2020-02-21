package algorithm.leetcode.二叉树;

public class L74_search2dmatrix {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        if(rows==0){
            return false;
        }
        int columns = matrix[0].length;
        int start = 0;
        int end = rows*columns-1;

        while(start<=end){
            int middle_idx = (end+start)/2;
            int middle_val=  getval(matrix,middle_idx,columns);
            if(target==middle_val)
                return true;
            if(target>middle_val){
                start = middle_idx+1;
            }else {
                end = middle_idx-1;
            }

        }
        return false;

    }

    private int  getval(int[][] matrix,int position,int columnsize)
    {
        int row_idx    = position / columnsize;
        int column_idx = position % columnsize;
        return matrix[row_idx][column_idx];
    }
}
