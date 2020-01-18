class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        this.backtrack(nums, new LinkedList<>(), new boolean[nums.length]);
        return this.res;
    }

    private void backtrack(int[] nums, LinkedList<Integer> curr, boolean[] visited) {
        if (curr.size() == nums.length) {
            this.res.add(new ArrayList<>(curr));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && (nums[i] == nums[i - 1]) && visited[i - 1]) {
                continue;
            }
            curr.add(nums[i]);
            visited[i] = true;
            this.backtrack(nums, curr, visited);
            curr.removeLast();
            visited[i] = false;
        }
    }
}