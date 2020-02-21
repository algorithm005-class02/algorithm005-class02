class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> res = new ArrayList<Integer>();
        if(nums == null) {
            return list;
        }
        level(list, res, 0, nums);
        return list;
    }

    public void level(List<List<Integer>> list, List<Integer> res, int index, int[] nums) {
        if (index == nums.length) {
            list.add(new ArrayList<Integer>(res));
            return;
        }
        level(list, res, index+1, nums);
        res.add(nums[index]);
        level(list,res,index+1, nums);
        res.remove(res.size() - 1);
    }
}