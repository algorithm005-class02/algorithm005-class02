class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.size() + 1];

        for (int level = triangle.size() - 1; level >= 0; level--) {
            for (int i = 0; i <= level; i++) {
                res[i] = Math.min(res[i], res[i + 1]) + triangle.get(level).get(i);
            }
        }

        return res[0];
    }
}