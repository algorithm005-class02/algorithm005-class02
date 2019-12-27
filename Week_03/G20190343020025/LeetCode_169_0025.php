<?php
// 多数元素
$nums = [3, 2, 3];
$nums = [2, 2, 1, 1, 1, 2, 2];
$Solution = new Solution();
var_dump($Solution->majorityElement($nums));
var_dump($Solution->majorityElement1($nums));
var_dump($Solution->majorityElement2($nums));

class Solution
{
    // 投票方法
    function majorityElement($nums)
    {
        $count = 0;
        $current = 0;
        foreach ($nums as $value) {
            if ($count == 0) {
                $current = $value;
                $count++;
            } elseif ($current == $value) {
                $count++;
            } else {
                $count--;
            }
        }
        return $current;
    }

    // 系统函数 排序方法
    function majorityElement1($nums)
    {
        sort($nums);
        return $nums[count($nums) / 2];
    }

    // 分治方法
    function majorityElement2($nums)
    {
        return $this->_majorityElement($nums, 0, count($nums) - 1);
    }

    private function _majorityElement($nums, $l, $r)
    {
        if ($l == $r) return $nums[$l];
        $mid = floor(($r - $l) / 2) + $l;
        $left = $this->_majorityElement($nums, $l, $mid);
        $right = $this->_majorityElement($nums, $mid + 1, $r);
        if ($left == $right) return $left;
        $leftCount = $this->_countInRange($nums, $left, $l, $r);
        $rightCount = $this->_countInRange($nums, $r, $l, $r);
        return $leftCount > $rightCount ? $left : $right;
    }


    private function _countInRange($nums, $num, $l, $r)
    {
        $count = 0;
        for ($i = $l; $i <= $r; $i++) {
            if ($nums[$i] == $num) $count++;
        }
        return $count;
    }
}
