package G20190343020171


/*
 * @lc app=leetcode.cn id=189 lang=golang
 *
 * [189] 旋转数组
 */

// @lc code=start
func rotate(nums []int, k int)  {
	// 初始解法暴力解法
	// 反转递归
	k %= len(nums);
	reverse(nums, 0, len(nums) - 1)
	reverse(nums, 0, k-1)
	reverse(nums, k, len(nums) - 1)
}

func reverse(nums []int, start, end) {
	while (start < end) {
		temp := nums[start];
		nums[start] = nums[end];
		nums[end] = temp;
		start ++;
		end --;
	}
} 
// @lc code=end

