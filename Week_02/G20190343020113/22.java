class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(0, 0, n, "", list);
        return list;
    }

    public void generate(int left, int right, int n, String s, List<String> list) {
        if (left == n && right == n) {
            list.add(s);
            return;
        }
        if (left < n) {
            generate(left + 1, right, n, s + '(', list);
        }
        if (right < left) {
            generate(left, right + 1, n, s + ')', list);
        }
    }
}