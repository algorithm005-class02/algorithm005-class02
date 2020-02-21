<?php
// 搜索旋转排序数组


$nums =  [4, 5, 6, 7, 0, 1, 2];
$target = 0;
$Solution = new Solution();
var_dump($Solution->search($nums, $target));

class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function search($nums, $target)
    {
        $left = 0;
        $right  = count($nums);
        while ($left < $right) {
            $mid = floor(($right + $left) / 2);
            if ($nums[0] < $nums[$mid] && ($target > $nums[$mid] || $target < $nums[0])) {
                $left = $mid + 1;
            } elseif ($target > $nums[$mid] && $target < $nums[0]) {
                $left = $mid + 1;
            } else {
                $right = $mid;
            }
        }
        return $left == $right && $nums[$left] == $target ? $left : -1;
    }
}
