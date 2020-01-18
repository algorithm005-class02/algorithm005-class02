class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, 0, result, new ArrayList<Integer>());
        return result;
    }

    public void helper(int[] nums,
                       int index,
                       List<List<Integer>> result,
                       List<Integer> tmp) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(tmp));
            return;
        }
        // 先不加
        helper(nums, index + 1, result, tmp);
        tmp.add(nums[index]);
        // 先加
        helper(nums, index + 1, result, tmp);
        // reverse state
        tmp.remove(tmp.size() - 1);
    }
}