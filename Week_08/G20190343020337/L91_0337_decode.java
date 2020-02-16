package algorithm.leetcode.高级动态规划;

import java.util.HashMap;
import java.util.Map;

public class L91_decode {

	static Map<Integer, Character> charMap = new HashMap<Integer, Character>();
	public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	static {
		for (int start = 'A'; start < ('A' + 26); start++) {
			charMap.put(start - 'A' + 1, (char) start);
		}
	}

	private int count = 0;

	public int numDecodings(String s) {
//    	count=0;
//    	String result = "";
//    	decode(result,s,0,s.length());
//    	return count;
		return dp(s);

	}

	/**
	 * 青铜解法，没错误，但会超出时间
	 * 
	 * @param result
	 * @param s
	 * @param currentLevel
	 * @param maxLevel
	 */
	public void decode(String result, String s, int currentLevel, int maxLevel) {
		if (currentLevel == maxLevel) {
			count = count + 1;
			System.out.println(result);
			return;
		}
		if (currentLevel + 1 <= maxLevel) {
			String parseOne = s.substring(currentLevel, currentLevel + 1);
			int parsed = Integer.valueOf(parseOne);
			if (parsed != 0) {

				decode(result + charMap.get(parsed), s, currentLevel + 1, maxLevel);
			}
		}
		if (currentLevel + 2 <= maxLevel) {
			String parseTwo = s.substring(currentLevel, currentLevel + 2);

			int parsed = Integer.valueOf(parseTwo);
			if (parsed <= 26 && parsed >= 10) {
				decode(result + charMap.get(parsed), s, currentLevel + 2, maxLevel);
			}
		}

	}

	private int dp(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int length = s.length();
		int[] dp = new int[length];

		if (validsub(s, length - 1, 1)) {
			dp[length - 1] = 1;
		}
		if (length >= 2) {
			if (validsub(s, length - 2, 2)) {
				if (validsub(s, length - 1, 1)) {
					dp[length - 2] = 2;
				} else {
					dp[length - 2] = 1;
				}

			} else {
				if (validsub(s, length - 2, 1) && validsub(s, length - 1, 1)) {
					dp[length - 2] = 1;
				}
			}
		}
		int i = length - 3;
		while (i >= 0) {
			int p1 = 0;
			int p2 = 0;
			if (validsub(s, i, 1)) {
				p1 = dp[i + 1];
			}
			if (validsub(s, i, 2)) {
				p2 = dp[i + 2];
			}

			dp[i] = p1 + p2;
			i--;
		}

		return dp[0];
	}

	private boolean validsub(String s, int start, int len) {

		String p = s.substring(start, start + len);
		int parsed = Integer.valueOf(p);
		if (len == 1 && parsed != 0) {
			return true;
		}
		if (len == 2 && parsed <= 26 && parsed >= 10) {
			return true;
		}
		return false;

	}

	public static void main(String args[]) {
		String s = "9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253";
		L91_decode l = new L91_decode();
		l.numDecodings(s);

	}

}
