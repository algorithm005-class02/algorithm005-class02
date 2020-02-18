package com.solution;

public class LengthOfLIS300 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LengthOfLIS300 lis = new LengthOfLIS300();
		//int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
		int[] nums = {1,3,6,7,9,4,10,5,6};
		System.out.println(lis.lengthOfLIS(nums));

	}

	public int lengthOfLIS(int[] nums) {
		int len = nums.length;
		if(len ==0)return 0;
		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			int max=0;
			for (int j = i; j >= 0; j--) {
				if (nums[j] < nums[i]) {
					max = Math.max(dp[j], max);
				}
			}
			dp[i] = max + 1;
		}
		int max = 0;
		for (int i = 0; i < dp.length; i++) {
			max = Math.max(dp[i], max);
		}
		return max;

	}
}
