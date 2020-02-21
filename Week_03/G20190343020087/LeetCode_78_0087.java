import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=78 lang=java
 *
 * [78] 子集
 * 
 */

// @lc code=start
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // 给的数组为空就直接返回空，不为空就向下
        if (nums != null) backtrack(res, nums, new ArrayList<Integer>(), 0);
        return res;
    }

    public void backtrack(List<List<Integer>> res, int[] nums, List<Integer> list, int index) {
        // 终止条件：递归层数等于输入数组长度时，代表递归已经到最后一层了，将所有子树的结果合并
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }

        // 两条分支，第一条不加元素
        backtrack(res, nums, list, index + 1);
        list.add(nums[index]);
        // 第二条要加元素
        backtrack(res, nums, list, index + 1);

        // 因为改变的是参数，参数是向下传递的，所以为了不影响上层，最后需要将这层list添加的删除
        list.remove(list.size() - 1);
    }
}
// @lc code=end

