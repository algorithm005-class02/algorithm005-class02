<?php
// 153. 寻找旋转排序数组中的最小值

$nums = [3, 4, 5, 1, 2];
$nums = [1, 2];
$nums = [2, 1];
$Solution = new Solution();
var_dump($Solution->findMin($nums));

class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer
     * 二分查找
     */
    function findMin($nums)
    {
        $left = 0;
        $right = count($nums) - 1;
        if ($right == 0 || $nums[0] < $nums[$right]) {
            return $nums[0];
        }
        while ($left <= $right) {
            $mid = $left + floor(($right - $left) / 2);
            if ($nums[$mid] > $nums[$mid + 1]) return $nums[$mid + 1];
            if ($nums[$mid] < $nums[$mid - 1]) return $nums[$mid];
            if ($nums[0] < $nums[$mid]) {
                $left = $mid + 1;
            } else {
                $right = $mid - 1;
            }
        }
        return null;
    }
}
