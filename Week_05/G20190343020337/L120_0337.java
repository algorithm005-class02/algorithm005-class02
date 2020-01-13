package algorithm.leetcode.动态规划;

import java.util.List;

public class L120_triangle {

    public int minimumTotal(List<List<Integer>> triangle) {

        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){

                A[j]=Math.min(A[j],A[j+1])+triangle.get(i).get(j);

            }
        }
        return 0;

        //return helper(0,0,triangle);
    }
    private int helper(int level,int c,List<List<Integer>> triangle){

        if(level==triangle.size()-1){
            return triangle.get(level).get(c);
        }
        int left = helper(level+1,c,triangle);
        int right = helper(level+1,c,triangle);
        return Math.min(left,right)+triangle.get(level).get(c);

    }


}
