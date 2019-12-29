class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null)
            return false;
        if(matrix.length == 1 && (matrix[0] == null || matrix[0].length == 0))
            return false;
        int lo = 0;  
        int hi = matrix.length - 1;
        int len = matrix[0].length-1;
        if(target < matrix[0][0] || target > matrix[hi][len])
            return false;
        while(lo < hi){
            int mid = (hi - lo)/2 + lo;
            // if(matrix[mid][len] == target || matrix[mid][0] == target) {
            //     return true;
            // }
            if(matrix[mid][0] > target){
                hi = mid - 1;
            }else{
                if(matrix[mid][len] >= target) {
                    return helper(matrix[mid], target);
                }else {
                    lo = mid + 1;
                }
            }
        }
        return helper(matrix[lo],target);     
    }

    public boolean helper(int[] temp,int target){
        int start = 0;
        int end = temp.length -1;
        if(target < temp[0] || target > temp[end])
            return false;
        while(start < end){
            int submid = (end - start)/2 + start;
            if(target == temp[submid])
                return true;
            if(target < temp[submid]){
                end = submid - 1;
            }else{
                start = submid + 1;
            }
        }
        return start == end && temp[start] == target;
        
    }
}