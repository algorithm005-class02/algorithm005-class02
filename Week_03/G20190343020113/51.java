class Solution {
    public List<List<String>> list = new ArrayList<List<String>>();
    public Set<Integer> cols = new HashSet<Integer>();
    public Set<Integer> leftRight = new HashSet<Integer>();
    public Set<Integer> rightLeft = new HashSet<Integer>();

    public List<List<String>> solveNQueens(int n) {
        Stack<Integer> res = new Stack<Integer>();
        level(res, 0, n);
        return list;
    }

    public List<String> convert2Str(Stack<Integer> res, int n) {
        List<String> strings = new ArrayList<String>();
        for (int j : res) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int z = 0; z < n;z++) {
                if (j == z) {
                    stringBuilder.append("Q");
                } else {
                    stringBuilder.append(".");
                }
            }
            strings.add(stringBuilder.toString());
        }
        return strings;
    }

    public void level(Stack<Integer> res, int index, int n) {
        if (index == n) {
            list.add(convert2Str(res, n));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (cols.contains(i) || leftRight.contains(i - index) || rightLeft.contains(i + index)) {
                continue;
            }
            cols.add(i);
            leftRight.add(i - index);
            rightLeft.add(i + index);
            res.push(i);
            level(res, index + 1, n);
            cols.remove(i);
            leftRight.remove(i - index);
            rightLeft.remove(i + index);
            res.pop();
        }
    }
}