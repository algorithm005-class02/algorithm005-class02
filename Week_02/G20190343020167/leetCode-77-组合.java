class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), k, 1, n-k+1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int kLeft, int from, int to) {
        if (kLeft == 0) { 
            ans.add(new ArrayList<Integer>(list)); 
            return;
        }
        for (int i=from; i<=to; ++i) {
            list.add(i);
            dfs(ans, list, kLeft-1, i+1, to+1);
            list.remove(list.size()-1);
        }
    }
}