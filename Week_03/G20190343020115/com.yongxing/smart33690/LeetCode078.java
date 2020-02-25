package smart33690;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 */
public class LeetCode078 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        for(List<Integer> n : res){
            System.out.println(n);
        }
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        if(nums == null) {
            return ans;
        }
        dfs(ans,nums,new ArrayList(),0);
        return ans;
    }
    private static void dfs(List<List<Integer>> ans,int[] nums,List<Integer> list,int index){
        //terminator
        if(index == nums.length) {
            ans.add(new ArrayList(list));
            return;
        }
        dfs(ans,nums,list,index+1);
        list.add(nums[index]);
        dfs(ans,nums,list,index+1);

        list.remove(list.size()-1);
    }
}
