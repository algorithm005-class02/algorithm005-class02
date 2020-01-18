public class GenerateParentheses {
    private List<String> result;
    public List<String> generateParentheses(int n) {
        result = new ArrayList<String>();
        recur(0,0,n,"");
        return result;
    }

    public void recur(int left, int right, int n, String s) {
        if (left == n && right == n) {
            result.add(s);
        }

        if (left < n) {
            recur(left + 1, right, n, s + "(");
        }
        if (right < left) {
            recur(left, right + 1, n, s + ")");
        }

    }

    public static void main(String[] args) {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        System.out.println(generateParentheses.generateParentheses(3));
    }
}