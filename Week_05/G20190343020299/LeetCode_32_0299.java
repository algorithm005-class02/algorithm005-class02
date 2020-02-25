import java.util.Stack;

public class LeetCode_32_0299 {
    public static void main(String[] args) {
        System.out.println(new LeetCode_32_0299().longestValidParentheses("(()"));
    }


    public int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j)))
                    maxLen = Math.max(maxLen, j - i);
            }
        }
        return maxLen;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}
