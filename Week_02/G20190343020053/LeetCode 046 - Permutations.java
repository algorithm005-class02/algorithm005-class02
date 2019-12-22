class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int length = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[] flags = new boolean[length];
        for (int i = 0;i < length; i++) {
            flags[i] = true;
            dfs(res, flags, new int[length], nums, nums[i], 0, length);
            flags[i] = false;
        }
        return res;
    }
    
    private void dfs(List<List<Integer>> res, boolean[] flags, int[] array, int[] nums, int num, int index, int length) {
        array[index++] = num;
        if (index == length) {
            List<Integer> list = new ArrayList<>();
            for (int i : array) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = 0;i < length; i++) {
            if (!flags[i]) {
                flags[i] = true;
                dfs(res, flags, array, nums, nums[i], index, length);
                flags[i] = false;
            }
        }
    }
}