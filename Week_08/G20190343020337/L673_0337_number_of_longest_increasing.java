package algorithm.leetcode.高级动态规划;

import java.util.Arrays;

public class L673_number_of_longest_increasing {
	public int findNumberOfLIS(int[] nums) {
		int N = nums.length;
		if (N <= 1)
			return N;
		int[] lengths = new int[N]; // lengths[i] = length of longest ending in nums[i]
		int[] counts = new int[N]; // count[i] = number of longest ending in nums[i]
		Arrays.fill(counts, 1);
		//0..i..j
		for (int j = 0; j < N; ++j) {
			for (int i = 0; i < j; ++i)
				if (nums[i] < nums[j]) {
					if (lengths[i] >= lengths[j]) {
						lengths[j] = lengths[i] + 1;
						counts[j] = counts[i];
					} else if (lengths[i] + 1 == lengths[j]) {
						counts[j] += counts[i];
					}
				}
		}

		int longest = 0, ans = 0;
		for (int length : lengths) {
			longest = Math.max(longest, length);
		}
		for (int i = 0; i < N; ++i) {
			if (lengths[i] == longest) {
				ans += counts[i];
			}
		}
		return ans;
	}

}
