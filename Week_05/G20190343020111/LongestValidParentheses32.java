package com.solution;

import java.util.Stack;

/*
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 */
public class LongestValidParentheses32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int x = new LongestValidParentheses32().longestValidParentheses2("((())(()");
		System.out.println(x);
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
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

	/*
	 * 暴力硬解，内层循环：依次叠加取2个字符串进行比较是否有效，如果有效记录长度。 
	 * 外层循环：依次前进一个字符串 把此字条串的每种情况都进行了计算
	 *
	 * 把字符串的每种情况都进行比较，如：((()) 1.(( 2.((() 3.((()) 4.(( 5.(()) 6.() 7.()) 8.))
	 * 
	 */
	public int longestValidParentheses(String s) {
		int maxlen = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (isValid(s.substring(i, j))) {
					maxlen = Math.max(maxlen, j - i);
				}
			}
		}
		return maxlen;
	}

	/*
	 * DP方式实现： DP 方程： 如果 s[i]=')' 并且 s[i-1]='(' 则 dp[i]=dp[i-2]+2 如果s[i]=‘)’ 且
	 * s[i−1]=‘)’ 且 s[i-dp[i-1]-1]='(' 则 dp [i]= dp[i-1] + 2 + dp[i-dp[i-1]-2]
	 */
	public int longestValidParentheses2(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (s.charAt(i - 1) == '(') {
					dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
				} else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
				}
				maxans = Math.max(maxans, dp[i]);
			}
		}
		return maxans;
	}

}
