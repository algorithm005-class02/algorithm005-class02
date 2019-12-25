class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] array = new int[k];
        for (int i = 1;i <= (n - k + 1); i++) {
            dfs(res, array, i, 0, n, k);
        }
        return res;
    }
    
    private void dfs(List<List<Integer>> res, int[] array, int num, int index, int n, int length) {
        array[index++] = num;
        if (index == length) {
            List<Integer> list = new ArrayList<>();
            for (int i : array) {
                list.add(i);
            }
            res.add(list);
            return;
        }
        for (int i = num + 1;i <= n; i++) {
            dfs(res, array, i, index, n, length);
        }
    }
}