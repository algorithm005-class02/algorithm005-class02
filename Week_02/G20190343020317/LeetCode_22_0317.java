class Solution {
    //递归加回溯
    List<String> result;
    public List<String> generateParenthesis(int n) {
        result = new LinkedList<>();
        generate(0, 0, n, "");
        return result;
    }
    private void generate(int left, int right, int terminator, String curr) {
        if (left == terminator && right == terminator) {
            result.add(curr);
        }
        if (right > left || left > terminator) {
            return;
        } else {
            generate(left + 1, right, terminator, curr + "(");
            generate(left, right + 1, terminator, curr + ")");
        }
    }
}