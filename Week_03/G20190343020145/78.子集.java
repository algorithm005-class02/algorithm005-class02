/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 *
 * https://leetcode-cn.com/problems/subsets/description/
 *
 * algorithms
 * Medium (75.56%)
 * Likes:    421
 * Dislikes: 0
 * Total Accepted:    51.5K
 * Total Submissions: 68K
 * Testcase Example:  '[1,2,3]'
 *
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 
 * 说明：解集不能包含重复的子集。
 * 
 * 示例:
 * 
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 * ⁠ [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 */

// @lc code=start
//分治
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null) return result;
        dfs(result,nums,new ArrayList<Integer>(),0);
        return result;
        
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> list, int index) {
        //Teminator
        if(index == nums.length){
            result.add(new ArrayList<Integer>(list));
            return ;
        }

        //not pick the number
        dfs(result,nums,list,index +1);

        //pick the number
        list.add(nums[index]);
        dfs(result,nums,list,index +1);

        //reverse
        list.remove(list.size() - 1);
        
    }



}

//迭代法1，会超时，大量冗余计算，二层循环的size会每循环一次就变。
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         Arrays.sort(nums); // make sure subsets are ordered
//         List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>()); // start with empty set
//         for (int i = 0; i < nums.length; ++i) {
//             for (int j = 0 ; j < result.size() ; ++j) { // remember
//                 List<Integer> subset = new ArrayList<>(result.get(j)); // copy a new one
//                 subset.add(nums[i]); // expand
//                 result.add(subset); // collect
//             }
//         }
//         return result;
//     }
// }

/*上一迭代法的优化，迭代法二，保证每次循环size不会更新，所以提前在下一层循环开始前，
保存当前的size，避免了大量冗余的重复计算。
/*从无到有，每次循环n+1,对应的size也+1，这样原来的二维集合元素的每一个一
维元素集合，都被加上了对应的新的数组元素，比如现在的集合为[[],[1],[2],[1,2]],这次轮询到
n=num[2]=3,那么n的值就会加到集合的每一个一维集合中，将新的一维集合元素组添加到原来的二维集合中，
最后的结果就为[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]*/
// class Solution {
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         result.add(new ArrayList<>());
//         for(int n:nums){
//             int size = result.size();
//             for(int i = 0;i < size;++ i){
//             List<Integer> subset = new ArrayList<>(result.get(i));
//             subset.add(n);
//             result.add(subset);
//             }
//         }
//         return result;

//     }
// }

// @lc code=end

