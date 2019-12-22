class Solution {

    List<String> result = new ArrayList<String>();

    public List<String> generateParenthesis(int n) {
        _generate(0, 0, n, "");
        return result;
    }

    public void _generate(int left, int right, int max, String str) {
        if (left == max && right == max) {
            result.add(str);
            return;
        }

        if (left < max) {
            _generate(left + 1, right, max, str + "(");
        }
        if (right < left) {
            _generate(left, right + 1, max, str + ")");
        }
    }
}