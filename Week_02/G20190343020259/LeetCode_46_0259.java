class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        this.backtrack(nums, new LinkedList<>());
        return this.res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> curr) {
        if (curr.size() == nums.length) {
            this.res.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (curr.contains(nums[i])) {
                continue;
            }
            curr.add(nums[i]);
            this.backtrack(nums, curr);
            curr.removeLast();
        }
    }
}