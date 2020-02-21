package com.solution;

public class Search33 {

	public static void main(String[] args) {
		int nums[] = { 4, 5, 6, 7, 0, 1, 3 };
		int target = 2;
		System.out.println(new Search33().search(nums, target));

	}

	public int search(int[] nums, int target) {
		int lo = 0;
		int hi = nums.length - 1;
		int x = find_rotate_index(lo, hi, nums);
		if (nums[x - 1] >= target && nums[lo] <= target) {
			hi = x - 1;
		} else if (nums[x] <= target && nums[hi] >= target) {
			lo = x;
		} else {
			return 0;
		}
		// binary search.
		int mid = 0;
		while (true) {
			mid = (hi - lo) / 2 + lo;
			if (nums[mid] == target) {
				return 1;
			}
			if (lo == hi) {
				return 0;
			}
			if (nums[mid] > target) {
				hi = mid;
				mid = (mid - lo) / 2 + lo;
			} else {
				lo = mid + 1;
				mid = (hi - mid) / 2 + lo;
			}
		}

	}

	public int find_rotate_index(int left, int right, int[] nums) {
		if (nums[left] < nums[right])
			return 0;

		while (left <= right) {
			int pivot = (left + right) / 2;
			if (nums[pivot] > nums[pivot + 1])
				return pivot + 1;
			else {
				if (nums[pivot] < nums[left])
					right = pivot - 1;
				else
					left = pivot + 1;
			}
		}
		return 0;
	}
	/*
	 * public int search(int left, int right,int[] nums, int target) {
	 * 
	 * while (left <= right) { int pivot = (left + right) / 2; if (nums[pivot] ==
	 * target) return pivot; else { if (target < nums[pivot]) right = pivot - 1;
	 * else left = pivot + 1; } } return -1; }
	 * 
	 * public int search2(int[] nums, int target) {
	 * 
	 * 
	 * int n = nums.length;
	 * 
	 * if (n == 0) return -1; if (n == 1) return nums[0] == target ? 0 : -1;
	 * 
	 * int rotate_index = find_rotate_index(0, n - 1, nums);
	 * 
	 * // if target is the smallest element if (nums[rotate_index] == target) return
	 * rotate_index; // if array is not rotated, search in the entire array if
	 * (rotate_index == 0) return search(0, n - 1,nums,target); if (target <
	 * nums[0]) // search in the right side return search(rotate_index, n -
	 * 1,nums,target); // search in the left side return search(0,
	 * rotate_index,nums,target); }
	 */

}
