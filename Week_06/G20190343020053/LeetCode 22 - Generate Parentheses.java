class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList();
        process(res, "", 0, 0, n);
        return res;
    }
    
    private void process(List<String> res, String str, int open, int close, int pair) {
        if (open == pair && close == open) {
            res.add(str);
            return;
        }
        if (open < pair) {
            process(res, str + "(", open + 1, close, pair);
        }
        if (close < open) {
            process(res, str + ")", open, close + 1, pair);
        }
    }
}