package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * * @author jiangli
 * * @date 2019/12/25 10:22
 * * @description subsets 子集
 */
public class LeetCode_78_0097 {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        LeetCode_78_0097 l = new LeetCode_78_0097();
        List<List<Integer>> subsets = l.subsets2(nums);
        System.out.println(subsets);
    }

    /**
     * 循环
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int size = results.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newSubs = new ArrayList<>(results.get(j));
                newSubs.add(num);
                results.add(newSubs);
            }
        }
        return results;
    }

    /**
     * 递归
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        dfs(res,nums,0,new ArrayList<>());
        return res;
    }

    public void dfs(List<List<Integer>> res,int[] nums,int index,List<Integer> list){
        //terminator
        if(index == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        //not pick the num at this index
        dfs(res,nums,index+1,list);
        //pick the number at the index
        list.add(nums[index]);
        dfs(res,nums,index+1,list);

        //reverse the current state
        list.remove(list.size()-1);
        System.out.println("index->"+index+",list->"+list);
    }

}
