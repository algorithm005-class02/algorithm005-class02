class Solution {
    private Set<Integer> column = new HashSet<>();
    private Set<Integer> hill = new HashSet<>();
    private Set<Integer> dale = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        this.backtrack(n, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int n, int level, List<String> curr, List<List<String>> res) {
        if (level == n) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (this.column.contains(i) || this.hill.contains(level+i) || this.dale.contains(level-i)) {
                continue;
            }

            char[] chars = new char[n];
            Arrays.fill(chars, '.');
            chars[i] = 'Q';
            String str = new String(chars);

            curr.add(str);
            this.column.add(i);
            this.hill.add(level+i);
            this.dale.add(level-i);

            this.backtrack(n, level+1, curr, res);

            curr.remove(curr.size()-1);
            this.column.remove(i);
            this.hill.remove(level+i);
            this.dale.remove(level-i);
        }
    }
}