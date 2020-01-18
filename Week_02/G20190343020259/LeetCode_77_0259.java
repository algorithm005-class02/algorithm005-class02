class Solution {
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || n < k) {
            return this.res;
        }
        this.backtrack(n, k, 1, new LinkedList<>());
        return this.res;
    }

    private void backtrack(int n, int k, int start, LinkedList<Integer> curr) {
        if (curr.size() == k) {
            this.res.add(new ArrayList<>(curr));
            return;
        }

        // origin: i <= n
        // max(i) + nextCount - 1 = n
        // nextCount = k - curr.size()
        // max(i) = n - (k - curr.size()) + 1
        for (int i = start; i <= n - (k - curr.size()) + 1; i++) {
            curr.add(i);
            this.backtrack(n, k, i + 1, curr);
            curr.removeLast();
        }
    }
}